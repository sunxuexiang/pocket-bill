package com.cloudfly.start.bill.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.mapper.BillUserMapper;
import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.service.BillUserService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<BillUserMapper,BillUser> implements BillUserService{

    @Value("${wechat.url}")
    private String url;
    @Autowired
    private BillUserMapper billUserMapper;

    @Override
    public R Login(String code) throws Exception {
        String jsCode = url.replaceAll("JSCODE",code);
        CloseableHttpResponse execute = HttpClients.createDefault().execute((HttpUriRequest) new HttpGet(jsCode));
        String html = EntityUtils.toString(execute.getEntity());
        JSONObject jsonObject = JSONObject.parseObject(html);
        String openid = jsonObject.getString("openid");
        if(null == openid) {
            return R.error("服务器繁忙，请稍后再试");
        }
        BillUser billUser = billUserMapper.selectOne(new LambdaQueryWrapper<BillUser>().eq(BillUser::getUserOpenid, openid));
        Integer i = saveOrGetUserId(billUser, openid);
        if (null == i) return R.error("服务器繁忙，请稍后再试");
        JSONObject jwt = JwtUtils.createJWT(i);
        return R.ok(jwt);
    }

    @Override
    public R addUser(BillUser billUser) {
        Integer currentLoginUser = JwtUtils.getCurrentLoginUser();
        billUser.setUserId(currentLoginUser);
        if (billUserMapper.updateById(billUser) > 0) {
            return R.ok("修改成功");
        }
        return R.error("修改失败");
    }

    @Override
    public R queryUserInfo() {
        Integer currentLoginUser = JwtUtils.getCurrentLoginUser();
        BillUser billUser = billUserMapper.selectById(currentLoginUser);
        return R.ok(billUser);
    }

    private Integer saveOrGetUserId(BillUser billUser, String openId){
        try {
            if (null == billUser) {
                billUser = new BillUser();
                billUser.setUserOpenid(openId);
                billUser.setCreateDate(new Date());
                billUserMapper.insert(billUser);
                return billUser.getUserId();
            } else {
                return billUser.getUserId();
            }
        } catch (Exception e) {
            log.debug("saveOrGetUserId error ==== "+e);
            return null;
        }

    }

}
