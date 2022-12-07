package com.cloudfly.start.bill.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.mysql.cj.util.StringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static String SECRET = "A0B1C2D3E4F5G6H7I8J9KALBMCNDOEPFQ0R1S2T3U4V5W6X7Y8Z9";

    private static final Long EXPIRATION_TIME = Long.valueOf(2592000L);

    private static final String TOKEN_PREFIX = "Bearer";
    public static JSONObject createJWT(int userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        long nowMillis = System.currentTimeMillis();
        long ttlMillis = EXPIRATION_TIME.longValue() * 1000L;
        long expMillis = nowMillis + ttlMillis;
        Date now = new Date(nowMillis);
        Date exp = new Date(expMillis);
        String jwt = Jwts.builder().setClaims(map).setExpiration(exp).setIssuedAt(now).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        JSONObject json = new JSONObject();
        String token = "Bearer " + jwt;
        json.put("token", token);
        json.put("token-type", "Bearer");
        json.put("expire-time", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(exp));
        json.put("userId", map.get("userId"));
        CacheBuilder.newBuilder().build().put(token,userId);
        return json;
    }


    public static Integer getCurrentLoginUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("Authorization");
            if (StringUtils.isNullOrEmpty(token))
                throw new Exception("登录信息失效");
            Jwt decode = JwtHelper.decode(token.replace("Bearer ", ""));
            JSONObject userJson = JSONObject.parseObject(decode.getClaims());
            return userJson.getInteger("userId");
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}
