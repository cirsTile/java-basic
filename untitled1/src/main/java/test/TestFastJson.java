package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/2
 */

public class TestFastJson {
    public static void main(String[] args) {
        String str = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"acctId\": 11,\n" +
                "      \"organId\": 67,\n" +
                "      \"acctName\": \"海文花园账套\",\n" +
                "      \"acctCode\": null,\n" +
                "      \"remark\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"acctId\": 10010059,\n" +
                "      \"organId\": 67,\n" +
                "      \"acctName\": \"炯炯赛of\",\n" +
                "      \"acctCode\": null,\n" +
                "      \"remark\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"acctId\": 10010060,\n" +
                "      \"organId\": 1300,\n" +
                "      \"acctName\": \"Miss-阳光3\",\n" +
                "      \"acctCode\": \"MISS-Y\",\n" +
                "      \"remark\": \"Miss-阳光（专用账套勿动）\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"acctId\": 10010067,\n" +
                "      \"organId\": 1300,\n" +
                "      \"acctName\": \"234\",\n" +
                "      \"acctCode\": \"234\",\n" +
                "      \"remark\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"acctId\": 10010068,\n" +
                "      \"organId\": 1300,\n" +
                "      \"acctName\": \"四格\",\n" +
                "      \"acctCode\": \"segi\",\n" +
                "      \"remark\": \"测试\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"acctId\": 10010072,\n" +
                "      \"organId\": 1300,\n" +
                "      \"acctName\": \"谷歌公司\",\n" +
                "      \"acctCode\": \"google\",\n" +
                "      \"remark\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(str);
        String r = jsonObject.getString("data");
        JSONArray jsonArray = JSON.parseArray(r);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            System.out.println(jsonObject1.toJSONString());
            Map<String, Object>  map = new HashMap<String, Object>();
            map.put("acctId",jsonObject1.getString("acctId"));
            map.put("organId",jsonObject1.getString("organId"));
            map.put("acctName",jsonObject1.getString("acctName"));
            map.put("acctCode",jsonObject1.getString("acctCode"));
            map.put("remark",jsonObject1.getString("remark"));
            list.add(map);
        }
        System.out.println(list);
    }
}
