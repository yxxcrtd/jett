package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("test")
@RestController
public class TestController {

    @GetMapping("simple")
    public ModelAndView test() {
        Map<String, Object> map = new HashMap<>();
        map.put("year", 2022);

        List<Object> list = new ArrayList<>();

        User user1 = new User();
        user1.setId("1");
        user1.setName("张三");
        user1.setAge(9);
        list.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setName("李四");
        user2.setAge(12);
        list.add(user2);

        map.put("list", list);

        return new ModelAndView(new JettView("test.xlsx", "output"), map);
    }
    
    @GetMapping("group")
    public ModelAndView group() {
        Map<String, Object> map = new HashMap<>();

        List<String> titles = new ArrayList<>();
        titles.add("2020.05.31");
        titles.add("2020.12.31");
        titles.add("2021.12.31");
        titles.add("2022.01.31");
        titles.add("2022.02.28");
        map.put("titles", titles);


        List<TestObject> list = new ArrayList<>();

        TestObject testObject1 = new TestObject();
        testObject1.setMonth("1");
        testObject1.setBqye((float) 2314872.31);
        testObject1.setSqye((float) 213908742.01);
        testObject1.setName("大连银行");
        testObject1.setDept("1.按存放行分布统计");
        list.add(testObject1);

        TestObject testObject11 = new TestObject();
        testObject11.setMonth("1");
        testObject11.setBqye((float) 543234.77);
        testObject11.setSqye((float) 234549.82);
        testObject11.setName("平安银行");
        testObject11.setDept("1.按存放行分布统计");
        list.add(testObject11);

        TestObject testObject13 = new TestObject();
        testObject13.setMonth("1");
        testObject13.setBqye((float) 23453453.21);
        testObject13.setSqye((float) 4683.58);
        testObject13.setName("中国银行");
        testObject13.setDept("1.按存放行分布统计");
        list.add(testObject13);

        TestObject testObject2 = new TestObject();
        testObject2.setMonth("1");
        testObject2.setBqye((float) 87152456.6);
        testObject2.setSqye((float) 565242.3);
        testObject2.setName("北京银行");
        testObject2.setDept("2.按业务品种分类统计");
        list.add(testObject2);
        map.put("list", list);

        return new ModelAndView(new JettView("template.xlsx", "group"), map);
    }

    // protected Map<String, Object> getBeansMap() {
    //     Map<String, Object> beans = TestUtility.getDivisionData();
    //     beans.putAll(TestUtility.getStateData());
    //     beans.putAll(TestUtility.getSpecificDivisionData(4, "pacific"));
    //     beans.putAll(TestUtility.getSpecificDivisionData(7, "ofTheirOwn"));
    //     beans.putAll(TestUtility.getFictionalCountyData());
    //     return beans;
    // }

    // public static Map<String, Object> getStateData() {
    //     Map<String, Object> beans = new HashMap<>();
    //     beans.put("california", getCalifornia());
    //     beans.put("nevada", getNevada());

    //     return beans;
    // }

    // private static State getCalifornia() {
    //     State california = new State();
    //     california.setName("California");
    //     california.addCounty(new County("Los Angeles", 10363850, 10515, 1850, "Los Angeles", "06037"));
    //     california.addCounty(new County("San Diego", 3146274, 10888, 1850, "San Diego", "06073"));
    //     california.addCounty(new County("Orange", 3121251, 2046, 1889, "Santa Ana", "06059"));
    //     california.addCounty(new County("Riverside", 2088322, 18669, 1893, "Riverside", "06065"));
    //     california.addCounty(new County("San Bernardino", 2055766, 51960, 1853, "San Bernardino", "06071"));
    //     california.addCounty(new County("Santa Clara", 1837075, 3344, 1850, "Santa Clara", "06085"));
    //     california.addCounty(new County("Alameda", 1543000, 1911, 1853, "Oakland", "06001"));
    //     california.addCounty(new County("Sacramento", 1424415, 2502, 1850, "Sacramento", "06067"));
    //     california.addCounty(new County("Contra Costa", 1051674, 1865, 1850, "Martinez", "06013"));
    //     california.addCounty(new County("Fresno", 931098, 15444, 1856, "Fresno", "06019"));
    //     california.addCounty(new County("San Francisco", 845559, 122, 1850, "San Francisco", "06075"));
    //     california.addCounty(new County("Ventura", 831587, 4781, 1872, "Ventura", "06111"));
    //     california.addCounty(new County("Kern", 817517, 21088, 1866, "Bakersfield", "06029"));
    //     california.addCounty(new County("San Mateo", 739469, 1163, 1856, "San Mateo", "06081"));
    //     california.addCounty(new County("San Joaquin", 685660, 3623, 1850, "Stockton", "06077"));
    //     california.addCounty(new County("Stanislaus", 525903, 3872, 1854, "Modesto", "06099"));
    //     california.addCounty(new County("Sonoma", 484470, 4082, 1850, "Santa Rosa", "06097"));
    //     california.addCounty(new County("Tulare", 435254, 12494, 1852, "Visalia", "06107"));
    //     california.addCounty(new County("Santa Barbara", 428655, 7091, 1850, "Santa Barbara", "06083"));
    //     california.addCounty(new County("Monterey", 428549, 8604, 1850, "Salinas", "06053"));
    //     california.addCounty(new County("Solano", 426757, 2145, 1850, "Fairfield", "06095"));
    //     california.addCounty(new County("Placer", 333401, 3893, 1851, "Auburn", "06061"));
    //     california.addCounty(new County("San Luis Obispo", 269337, 8557, 1850, "San Luis Obispo", "06079"));
    //     california.addCounty(new County("Santa Cruz", 266519, 1155, 1850, "Santa Cruz", "06087"));
    //     california.addCounty(new County("Marin", 257406, 1347, 1850, "San Rafael", "06041"));
    //     california.addCounty(new County("Merced", 255250, 4996, 1855, "Merced", "06047"));
    //     california.addCounty(new County("Butte", 220407, 4248, 1850, "Oroville", "06007"));
    //     california.addCounty(new County("Yolo", 199066, 2621, 1850, "Woodland", "06113"));
    //     california.addCounty(new County("Shasta", 182236, 9806, 1850, "Redding", "06089"));
    //     california.addCounty(new County("El Dorado", 179722, 4434, 1850, "Placerville", "06017"));
    //     california.addCounty(new County("Imperial", 176158, 10813, 1907, "El Centro", "06025"));
    //     california.addCounty(new County("Kings", 154434, 3600, 1893, "Hanford", "06031"));
    //     california.addCounty(new County("Madera", 150887, 5537, 1893, "Madera", "06039"));
    //     california.addCounty(new County("Napa", 136704, 1953, 1850, "Napa", "06055"));
    //     california.addCounty(new County("Humboldt", 132821, 9254, 1853, "Eureka", "06023"));
    //     california.addCounty(new County("Nevada", 99186, 2481, 1851, "Nevada City", "06057"));
    //     california.addCounty(new County("Sutter", 95878, 1562, 1850, "Sutter", "06101"));
    //     california.addCounty(new County("Mendocino", 90163, 9088, 1850, "Ukiah", "06045"));
    //     california.addCounty(new County("Yuba", 71929, 1632, 1850, "Yuba", "06115"));
    //     california.addCounty(new County("Lake", 64059, 3258, 1861, "Lakeport", "06033"));
    //     california.addCounty(new County("Tehama", 62419, 7643, 1856, "Red Bluff", "06103"));
    //     california.addCounty(new County("San Benito", 57784, 3597, 1874, "Hollister", "06069"));
    //     california.addCounty(new County("Tuolumne", 56799, 5791, 1850, "Tuolumne", "06109"));
    //     california.addCounty(new County("Calaveras", 46127, 2642, 1850, "San Andreas", "06009"));
    //     california.addCounty(new County("Siskiyou", 45971, 16283, 1852, "Yreka", "06093"));
    //     california.addCounty(new County("Amador", 37943, 1536, 1854, "Jackson", "06005"));
    //     california.addCounty(new County("Lassen", 35757, 11805, 1864, "Susanville", "06035"));
    //     california.addCounty(new County("Del Norte", 29419, 2611, 1850, "Crescent City", "06015"));
    //     california.addCounty(new County("Glenn", 29195, 3406, 1891, "Willows", "06021"));
    //     california.addCounty(new County("Colusa", 21910, 2981, 1850, "Colusa", "06011"));
    //     california.addCounty(new County("Plumas", 20917, 6615, 1854, "Quincy", "06063"));
    //     california.addCounty(new County("Mariposa", 18406, 3758, 1850, "Mariposa", "06043"));
    //     california.addCounty(new County("Inyo", 18152, 26397, 1866, "Independence", "06027"));
    //     california.addCounty(new County("Trinity", 13966, 8234, 1850, "Weaverville", "06105"));
    //     california.addCounty(new County("Mono", 13759, 7884, 1861, "Bridgeport", "06051"));
    //     california.addCounty(new County("Modoc", 9702, 10215, 1874, "Alturas", "06049"));
    //     california.addCounty(new County("Sierra", 3380, 2468, 1852, "Downieville", "06091"));
    //     california.addCounty(new County("Alpine", 1222, 1914, 1864, "Markleeville", "06003"));
    //     return california;
    // }

    // public County(String name, int population, double area, int establishedYear, String countySeat, String fipsCode){
    //     myName = name;
    //     myPopulation = population;
    //     myArea = area;
    //     myEstablishedYear = establishedYear;
    //     myCountySeat = countySeat;
    //     myFipsCode = fipsCode;
    // }
}
