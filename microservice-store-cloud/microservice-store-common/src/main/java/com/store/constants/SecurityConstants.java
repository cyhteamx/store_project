package com.store.constants;

/**
 * @author lengleng
 * @date 2017-12-18
 */
public interface SecurityConstants {

    /**
     * 前缀
     */
    String PIG_PREFIX = "pig_";

    /**
     * 用户信息头
     */
    String USER_HEADER = "x-user-header";

    /**
     * 角色信息头
     */
    String ROLE_HEADER = "x-role-header";

    /**
     * 项目的license
     */
    String PIG_LICENSE = "made by pig";

    /**
     * 基础角色
     */
    String BASE_ROLE = "ROLE_USER";

    /**
     * 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";

    /**
     * 密码模式
     */
    String PASSWORD = "password";

    /**
     * 刷新token
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * oauth token
     */
    String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 手机登录URL
     */
    String MOBILE_TOKEN_URL = "/mobile/token";

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 手机号的处理验证码的url前缀
     */
    String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * 默认生成图形验证码宽度
     */
    String DEFAULT_IMAGE_WIDTH = "150";

    /**
     * 默认生成图像验证码高度
     */
    String DEFAULT_IMAGE_HEIGHT = "32";

    /**
     * 默认生成图形验证码长度
     */
    String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * 默认生成图形验证码过期时间
     */
    int DEFAULT_IMAGE_EXPIRE = 60;

    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    String DEFAULT_COLOR_FONT = "black";

    /**
     * 图片边框
     */
    String DEFAULT_IMAGE_BORDER = "no";

    /**
     * 默认图片间隔
     */
    String DEFAULT_CHAR_SPACE = "5";

    /**
     * 默认保存code的前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";

    /**
     * 验证码文字大小
     */
    String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * 默认的social的登录地址
     */
    String DEFAULT_SOCIAL_PROCESS_URL = "/social";

    /**
     * 默认的social的注册地址
     */
    String DEFAULT_SOCIAL_SIGNUP_URL = "/social/signup";


    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     *JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from tb_sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    String PUBLIC_VERIFY_KEY = "-----BEGIN PUBLIC KEY-----\n" +
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAv1VEeQpMcs6shMp6GGWV\n" +
            "eIvDkOr7cH3ePIStPvRmK3yXazgek4mPQlsxH4dxUmnYT4sryc1gVdIfVkTPPkqW\n" +
            "Bph7n4mc/uQwfzYWzHOBxshexQEDez5rKEp33+qCYCZV229F5d+AofhLtmGXKqtu\n" +
            "FjM2+oNBz1pOAAPupZTH/0S4MReJSnGX90YH3wHhXzLH9ei9gO/XtZ0JtraZlU6n\n" +
            "sHK4vc4S4v90Ws7H+CsjAlUa66ZUdPBSgtWT2GL6CatauzvEBcoQMDBIxLHbVQeh\n" +
            "2FGueshOs0mMit1dQ45R2U24udCPV8vxRbk5Y6nsjDPYkCnxUVspYJa6Be4gEYyN\n" +
            "rv7aLfOp7soKMomUYR4PxB5gkwmsgDEC+B2Gm/wHgdxHYh43cn90of81aoq/5as/\n" +
            "iGQOAc5BoD9Pn+er63hL5yK7TmNsWyVHK5b3tp3c2uCoZKazDzGfOwbhIjvy5ldc\n" +
            "NOHBW62FvcqxRdTHRODjQxlwDDCNl5rx4WJwVFd8y/lcz1EE1WXSu2gsgHpXrgpv\n" +
            "lZ8AL6U4MtGv7QuA5Bj2uuoqvKy3qo+VsY7mjTkfII5Mb+WxHJOtMfoTWkl2m5A7\n" +
            "FTV4pOuJAgpqDSVcK79Koj8InKoyH5+6IGhEqxrLefvyC+H4Pm/q5ZVdqJL+eVXV\n" +
            "T9GdeoQ/IF+utQbWcgdUC9kCAwEAAQ==\n" +
            "-----END PUBLIC KEY-----\n";

    String PRIVATE_KEY_SIGNING_KEY_PKCS8 = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQC/VUR5CkxyzqyE\n" +
            "ynoYZZV4i8OQ6vtwfd48hK0+9GYrfJdrOB6TiY9CWzEfh3FSadhPiyvJzWBV0h9W\n" +
            "RM8+SpYGmHufiZz+5DB/NhbMc4HGyF7FAQN7PmsoSnff6oJgJlXbb0Xl34Ch+Eu2\n" +
            "YZcqq24WMzb6g0HPWk4AA+6llMf/RLgxF4lKcZf3RgffAeFfMsf16L2A79e1nQm2\n" +
            "tpmVTqewcri9zhLi/3Razsf4KyMCVRrrplR08FKC1ZPYYvoJq1q7O8QFyhAwMEjE\n" +
            "sdtVB6HYUa56yE6zSYyK3V1DjlHZTbi50I9Xy/FFuTljqeyMM9iQKfFRWylglroF\n" +
            "7iARjI2u/tot86nuygoyiZRhHg/EHmCTCayAMQL4HYab/AeB3EdiHjdyf3Sh/zVq\n" +
            "ir/lqz+IZA4BzkGgP0+f56vreEvnIrtOY2xbJUcrlve2ndza4KhkprMPMZ87BuEi\n" +
            "O/LmV1w04cFbrYW9yrFF1MdE4ONDGXAMMI2XmvHhYnBUV3zL+VzPUQTVZdK7aCyA\n" +
            "eleuCm+VnwAvpTgy0a/tC4DkGPa66iq8rLeqj5WxjuaNOR8gjkxv5bEck60x+hNa\n" +
            "SXabkDsVNXik64kCCmoNJVwrv0qiPwicqjIfn7ogaESrGst5+/IL4fg+b+rllV2o\n" +
            "kv55VdVP0Z16hD8gX661BtZyB1QL2QIDAQABAoICAQCWSc3NHa/LBlgwvjKFc1Wj\n" +
            "KHVnIYx7YgLsmnLS3npacjUl/SDXVtf2kVbWozb6OzWz1WeBzhZ7kt8WjloTXdbW\n" +
            "O3PvbtKozGjjo4Lo+VnY4I7AQ/mOFwtozIW4lqXuDG6oPJE07QhHMZeXHLT2yU1h\n" +
            "lrz6rZtF2nMmQ/Byk5k9A6eCuDAZD30EuDd6jimO835pxHUGEF7pwv5cTLX6t5u0\n" +
            "V4iRXosrTukAYyhj4M5RCLRqoW35pMPLDSRidexdKAHOzDU/LubkUyj1h5b3BVW1\n" +
            "awOYYjqfTYhdk1+srt/PxuLw4ceWeRV9ZO6VQGYUAq17H9bzxp2Lxxk7iz4ZSsQG\n" +
            "cRUb2lpez3wnzH8gtQRPulpW0YbJtOx/XqusvD3rrDRMXTDIeaElGjxkbyPi3MFv\n" +
            "mg2yGgNT+VmgYjwfj6AqbMAOFYO16wz4QMqOMWDttK0ASAXlSNMI6ZyhfnI5iorI\n" +
            "hmh+UUmh45ms+1s2xcwd9R+NgBpHJ5H7RZLbi0/gjq+NC4C5L1K0e863g/IIhlZo\n" +
            "cEGbnYXO6mSFWxma972r3hNRUq99m3kgwCyJJFxMNLZ1aauSGmf+SgomWwEFGQxC\n" +
            "shJfDh63qnF9HzRZ0PuZj3aTt8d2ly70CO9znnx707X/V08WX2o7fMcIksl5V40A\n" +
            "KOWXwof1DhhrMzCqbfOD4QKCAQEA+I2YnA1FjVVbw71JB0/odcYRjXEDhcbvsNoh\n" +
            "5tbx3oKnOxGfBfaoO1dmgc2mzHiraasDyLmP6Mcqsadla9+eeRc021zNVaywYMdy\n" +
            "OTHSGQgv8ZRw14M9ixY+mg6GZmHFN1rJ+MO//Aegy3lmqbd5nDDq3/ZLNi9Ox64Y\n" +
            "6x+m7CZkQjeHEbGkAEOn2auzCfcI2d5PRf7m3cBdmdZnr4URmLtwvFe4aPqgjrZU\n" +
            "xGi3plCiLVjQX13wlxpbYcMgbUHrk2JOZT33t9wvMYo94CenBZJHOL+DdMA/Xvwz\n" +
            "Z4gXnnPXrikWDX+/5GCAqa3W3sl0BRjyG82mGDbrj0zs4Tw8PQKCAQEAxRDLF9PB\n" +
            "kNW0PzyG/vaoIpIqTKH+hnaQSnvxgThH7pI2I//5KGyWHocLbVl5njdC2PYxNxC9\n" +
            "5GyzLN1lp9m1ndKiBcTsCRjJ+ac3ZOa2/u6V5QndXcIHqkCne8zh5FNJ1cewLoRU\n" +
            "key1J1cRQ2ZzJFJnAhQTGvwlVwu1JD0FEosHtkOM7bIstSoBe4QLgqY/dN4vRJdf\n" +
            "qjLvjdaThQp7y+nvCxh7gpo/7e5aAl2/lJzrDNnlJ2tKKzQIf0qHxIeARWUsnqHR\n" +
            "+P6jCfFLNUqxaPGZO7k2/nXHu/ScMUIy+LiU6ScFs0Q759u9lu6bMwitZDIEgOlt\n" +
            "rWWor9eWj6j7zQKCAQBV6qw8FSJbrovf54hc7LRQMb1ThSNQlOm52k0pvFczMTqZ\n" +
            "YofzycVxbc7TQ8FKoNOv3RubwPkL3/zUGCco2M2w0eLFiRi5as41Rfwn5R7Y5Eme\n" +
            "Wk9/T7BwaaoOGsM+lMFVVx7FzPSKLCDa9QYV2IRDB23JKRvqiQPUZkvaysAqlULG\n" +
            "2ObpqNwl8z0MMxvab/gxR3Vjnq8zLBGu4bxJodfpUbGwiSoHr8rcSg6XLhN9fBXz\n" +
            "UuYEcTZ/JO89pfOJkOXbtnme6YK9nXD60Ox+lXZYqK3R4fGQ4/uD2+3w9cwkS6rc\n" +
            "WvtygxxT1z/iZ2ME8+IU+QCHt9iYOjPG/zJK0UWJAoIBACTyPBFwiwbbehqs/2ZH\n" +
            "2kf4/WM2r+CH1A+S4zll0t6gnPPs5sq0aQS6LuNGdi26kJbauWlogyGTW5havddV\n" +
            "Ut6PAf9w5wvhkOR0fEc3ljF/i6zQR6dvXD6INp5YUDWdg+dHs/lUqAJfzardgQgQ\n" +
            "6h9yL4vNNbPGeD20nTZ5Fj1ewYhja8WYtRcWFAcTP5E0GAuSKGyEsNPZDt6ZzziP\n" +
            "OZyGdGGxKl7XCotSN5/f8a4sKUlUhMj6LYKiE8HBuGiZOuxHxrDLB/HV071mdsI8\n" +
            "CbzyJtdypyPX8yWC+9GkZqgI+yonPcNZVJ3orcfhXkmYI+H4Gq4MlZp/x7uIANtY\n" +
            "RDUCggEAekTJhmqbllXH9R3Rv4tMWzc09y7OQcQ7pNt04Uy/YYtpAjuzQsyzL7tb\n" +
            "EydRGkbQ0WAoJ2fP3P0AMvBTj87j4VbCsAblCea6uuSKjqIE7eJ9i+40taqVFaDL\n" +
            "8lSQWAoX2I0nT2g06/mqNDJ4I/6M0ykMyuTSnOWqeqF2oOYniaWczaGVGQ+cO1il\n" +
            "95Dh545kXy/O23QAy2pgfFrIRUW3y5ETEISg/EyvRgyyMDq47mrtGujbHINXz2vY\n" +
            "IwApwY+VVqPWh/+4wcsoNSMLDRGtnQ0efzrU30Ll380EiaczlVj6d1WkPeZ5kK5F\n" +
            "SMykW9ei8cdj/KdcNDVKBbGbT6WJGA==\n" +
            "-----END PRIVATE KEY-----\n";

    String PRIVATE_KEY_SIGNING_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIJKAIBAAKCAgEAv1VEeQpMcs6shMp6GGWVeIvDkOr7cH3ePIStPvRmK3yXazge\n" +
            "k4mPQlsxH4dxUmnYT4sryc1gVdIfVkTPPkqWBph7n4mc/uQwfzYWzHOBxshexQED\n" +
            "ez5rKEp33+qCYCZV229F5d+AofhLtmGXKqtuFjM2+oNBz1pOAAPupZTH/0S4MReJ\n" +
            "SnGX90YH3wHhXzLH9ei9gO/XtZ0JtraZlU6nsHK4vc4S4v90Ws7H+CsjAlUa66ZU\n" +
            "dPBSgtWT2GL6CatauzvEBcoQMDBIxLHbVQeh2FGueshOs0mMit1dQ45R2U24udCP\n" +
            "V8vxRbk5Y6nsjDPYkCnxUVspYJa6Be4gEYyNrv7aLfOp7soKMomUYR4PxB5gkwms\n" +
            "gDEC+B2Gm/wHgdxHYh43cn90of81aoq/5as/iGQOAc5BoD9Pn+er63hL5yK7TmNs\n" +
            "WyVHK5b3tp3c2uCoZKazDzGfOwbhIjvy5ldcNOHBW62FvcqxRdTHRODjQxlwDDCN\n" +
            "l5rx4WJwVFd8y/lcz1EE1WXSu2gsgHpXrgpvlZ8AL6U4MtGv7QuA5Bj2uuoqvKy3\n" +
            "qo+VsY7mjTkfII5Mb+WxHJOtMfoTWkl2m5A7FTV4pOuJAgpqDSVcK79Koj8InKoy\n" +
            "H5+6IGhEqxrLefvyC+H4Pm/q5ZVdqJL+eVXVT9GdeoQ/IF+utQbWcgdUC9kCAwEA\n" +
            "AQKCAgEAlknNzR2vywZYML4yhXNVoyh1ZyGMe2IC7Jpy0t56WnI1Jf0g11bX9pFW\n" +
            "1qM2+js1s9Vngc4We5LfFo5aE13W1jtz727SqMxo46OC6PlZ2OCOwEP5jhcLaMyF\n" +
            "uJal7gxuqDyRNO0IRzGXlxy09slNYZa8+q2bRdpzJkPwcpOZPQOngrgwGQ99BLg3\n" +
            "eo4pjvN+acR1BhBe6cL+XEy1+rebtFeIkV6LK07pAGMoY+DOUQi0aqFt+aTDyw0k\n" +
            "YnXsXSgBzsw1Py7m5FMo9YeW9wVVtWsDmGI6n02IXZNfrK7fz8bi8OHHlnkVfWTu\n" +
            "lUBmFAKtex/W88adi8cZO4s+GUrEBnEVG9paXs98J8x/ILUET7paVtGGybTsf16r\n" +
            "rLw966w0TF0wyHmhJRo8ZG8j4tzBb5oNshoDU/lZoGI8H4+gKmzADhWDtesM+EDK\n" +
            "jjFg7bStAEgF5UjTCOmcoX5yOYqKyIZoflFJoeOZrPtbNsXMHfUfjYAaRyeR+0WS\n" +
            "24tP4I6vjQuAuS9StHvOt4PyCIZWaHBBm52FzupkhVsZmve9q94TUVKvfZt5IMAs\n" +
            "iSRcTDS2dWmrkhpn/koKJlsBBRkMQrISXw4et6pxfR80WdD7mY92k7fHdpcu9Ajv\n" +
            "c558e9O1/1dPFl9qO3zHCJLJeVeNACjll8KH9Q4YazMwqm3zg+ECggEBAPiNmJwN\n" +
            "RY1VW8O9SQdP6HXGEY1xA4XG77DaIebW8d6CpzsRnwX2qDtXZoHNpsx4q2mrA8i5\n" +
            "j+jHKrGnZWvfnnkXNNtczVWssGDHcjkx0hkIL/GUcNeDPYsWPpoOhmZhxTdayfjD\n" +
            "v/wHoMt5Zqm3eZww6t/2SzYvTseuGOsfpuwmZEI3hxGxpABDp9mrswn3CNneT0X+\n" +
            "5t3AXZnWZ6+FEZi7cLxXuGj6oI62VMRot6ZQoi1Y0F9d8JcaW2HDIG1B65NiTmU9\n" +
            "97fcLzGKPeAnpwWSRzi/g3TAP178M2eIF55z164pFg1/v+RggKmt1t7JdAUY8hvN\n" +
            "phg2649M7OE8PD0CggEBAMUQyxfTwZDVtD88hv72qCKSKkyh/oZ2kEp78YE4R+6S\n" +
            "NiP/+Shslh6HC21ZeZ43Qtj2MTcQveRssyzdZafZtZ3SogXE7AkYyfmnN2Tmtv7u\n" +
            "leUJ3V3CB6pAp3vM4eRTSdXHsC6EVJHstSdXEUNmcyRSZwIUExr8JVcLtSQ9BRKL\n" +
            "B7ZDjO2yLLUqAXuEC4KmP3TeL0SXX6oy743Wk4UKe8vp7wsYe4KaP+3uWgJdv5Sc\n" +
            "6wzZ5SdrSis0CH9Kh8SHgEVlLJ6h0fj+ownxSzVKsWjxmTu5Nv51x7v0nDFCMvi4\n" +
            "lOknBbNEO+fbvZbumzMIrWQyBIDpba1lqK/Xlo+o+80CggEAVeqsPBUiW66L3+eI\n" +
            "XOy0UDG9U4UjUJTpudpNKbxXMzE6mWKH88nFcW3O00PBSqDTr90bm8D5C9/81Bgn\n" +
            "KNjNsNHixYkYuWrONUX8J+Ue2ORJnlpPf0+wcGmqDhrDPpTBVVcexcz0iiwg2vUG\n" +
            "FdiEQwdtySkb6okD1GZL2srAKpVCxtjm6ajcJfM9DDMb2m/4MUd1Y56vMywRruG8\n" +
            "SaHX6VGxsIkqB6/K3EoOly4TfXwV81LmBHE2fyTvPaXziZDl27Z5numCvZ1w+tDs\n" +
            "fpV2WKit0eHxkOP7g9vt8PXMJEuq3Fr7coMcU9c/4mdjBPPiFPkAh7fYmDozxv8y\n" +
            "StFFiQKCAQAk8jwRcIsG23oarP9mR9pH+P1jNq/gh9QPkuM5ZdLeoJzz7ObKtGkE\n" +
            "ui7jRnYtupCW2rlpaIMhk1uYWr3XVVLejwH/cOcL4ZDkdHxHN5Yxf4us0Eenb1w+\n" +
            "iDaeWFA1nYPnR7P5VKgCX82q3YEIEOofci+LzTWzxng9tJ02eRY9XsGIY2vFmLUX\n" +
            "FhQHEz+RNBgLkihshLDT2Q7emc84jzmchnRhsSpe1wqLUjef3/GuLClJVITI+i2C\n" +
            "ohPBwbhomTrsR8awywfx1dO9ZnbCPAm88ibXcqcj1/MlgvvRpGaoCPsqJz3DWVSd\n" +
            "6K3H4V5JmCPh+BquDJWaf8e7iADbWEQ1AoIBAHpEyYZqm5ZVx/Ud0b+LTFs3NPcu\n" +
            "zkHEO6TbdOFMv2GLaQI7s0LMsy+7WxMnURpG0NFgKCdnz9z9ADLwU4/O4+FWwrAG\n" +
            "5Qnmurrkio6iBO3ifYvuNLWqlRWgy/JUkFgKF9iNJ09oNOv5qjQyeCP+jNMpDMrk\n" +
            "0pzlqnqhdqDmJ4mlnM2hlRkPnDtYpfeQ4eeOZF8vztt0AMtqYHxayEVFt8uRExCE\n" +
            "oPxMr0YMsjA6uO5q7Rro2xyDV89r2CMAKcGPlVaj1of/uMHLKDUjCw0RrZ0NHn86\n" +
            "1N9C5d/NBImnM5VY+ndVpD3meZCuRUjMpFvXovHHY/ynXDQ1SgWxm0+liRg=\n" +
            "-----END RSA PRIVATE KEY-----\n";


    String PRIVATE_KEY_SIGNING_KEY1 = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA5aP/2VEGL/ZneHWof9prZTLbrS6WVAyLsADq4HE6Jzhpdvqi\n" +
            "JRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m8nUWKVN3C2/gFKIud9NMsYZh5FGP\n" +
            "ftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW9Um2FnA3OZ2O1t83r8OEk2Ks9wjR\n" +
            "YoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9takH9XJJR44eopbaTPD/JpmysnzS\n" +
            "vj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKMlHzJgatsD4mLEc5VvbR+GqZ4zc1n\n" +
            "ilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8iwIDAQABAoIBAA/dtN+e6X6G179K\n" +
            "4clzndfwG51ripdkBoKyjYfUSuBK1X6S8oD9RKz3Sr71FPKkwI5kYQW6KqwG1TZ2\n" +
            "DuoGPSKjVFSmn6L6p9DFI9DDmJjrX/gWaoOokKtNAKaktm84YVTYKzfc/XFtTBOa\n" +
            "/mcy2Xc5EIucVTR13liaM47BQ3erSCYQJvqxf0TZA1uqjJD9JHbtgijoEcE8IqqC\n" +
            "WN4NRVIugj/qJqwIvjhOzXNGbuumNKkA78xoJLIAuLrYh7HoS0jvNAp7BQXqnY6G\n" +
            "HW/cwatom/UpXpCn+cFLhQ5U7b+ulnQ0n20lP1C4sSfrwQdNhFRz5srxIe86E8yl\n" +
            "devOHoECgYEA9e8oKJbkjvkIQSC8sXpQUhGHO7z/m1ZU3khsjtBAdrtsMzhPVZqE\n" +
            "B4rqF7DHN5JyoYCsX0FDBGV6b7jR8WKIGacXPFEdWI2m1j8OCtVhza12udU54ql1\n" +
            "LxFp6uvBxogIesTIAH/wm8B1ctP/UIxnRNVeODyNFEWbYh0v8ZAhH4UCgYEA7wof\n" +
            "PlhAmelaOq5h0Ia9/AtYKnid28OeVI/8TGuQNV5uVUe+K2k6W8g9K2znnsEXq+y/\n" +
            "q7kkejXHTvXwH1POqsx91D6F4Yk2TkxpIZkSWu99DRX60wI0VgzCIszcUubzlPHH\n" +
            "r07hs0HetYeVM7a4EF/ThxuJgJp3joKsBYhxgM8CgYB9L8/xWV3eqUVaYZ+rd+eK\n" +
            "3wFHl11FZRyuSY944ujth1n8eJ1ppc2vSTb/+CxwTUusiiM0GbRTeJRqalnz1YQS\n" +
            "Csv5GBEoEnLqfA5Z1WSDndjhn3hnuHq+Cs8vlfJ9bKFkXOax2m5P2hfu65r7FX07\n" +
            "vKDJX4kw2H3P46uT+xnhQQKBgESsV8WFfSm6jJ2HM7rAuxwJ9k5dUJyuWnJY21bp\n" +
            "IAj1FCWT8uJt3MI5iLlNFE3bk31lCru++OfTQ2s/5LhbT2hqT0wGmlftH5jnAt0Q\n" +
            "KOHPI9H6mpC8dWSzTaLJ0BJRH3GO9Js8wkLJjb4BMbAlskOiBBcwphQ4TFi42crN\n" +
            "JC6pAoGAAe3I4OFaJOmQgDkf8NZ8n0bk8shSDNeWXtRudoTGHuf7brdyX3RxS7ui\n" +
            "jhUiwj0ENEBtHuxpxdP1rR95Ti5m80folqKuUKZmfwcQx8Eh16mQeg8x5OziDDaz\n" +
            "4egrrINBkb62RaS32VyT+becVqzGB0dJaLVDdYGwoqAYYNL+nZU=\n" +
            "-----END RSA PRIVATE KEY-----\n";

    String PUBLIC_VERIFY_KEY1 = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5aP/2VEGL/ZneHWof9pr\n" +
            "ZTLbrS6WVAyLsADq4HE6JzhpdvqiJRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m\n" +
            "8nUWKVN3C2/gFKIud9NMsYZh5FGPftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW\n" +
            "9Um2FnA3OZ2O1t83r8OEk2Ks9wjRYoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9\n" +
            "takH9XJJR44eopbaTPD/JpmysnzSvj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKM\n" +
            "lHzJgatsD4mLEc5VvbR+GqZ4zc1nilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8\n" +
            "iwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

}
