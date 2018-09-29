package club.small.util;

import club.small.entity.WordEntry;
import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExportWord {
    private WordEntry wordEntry = new WordEntry();
    private Configuration configuration = null;

    public ExportWord(){
        configuration = new Configuration();
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
    }

    public void createDoc() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("designTopic", "论啥呢，不知道");
        map.put("foreignLanguage", "what are you doing");
        map.put("major", "计算机科学与技术(游戏研发)");
        map.put("inSchoolTime", "2015级");
        map.put("college", "软件动漫学院");
        map.put("studentName", "金玉峰");
        map.put("schoolNumber", "20151943");
        map.put("teacherNameAndTitle", "金玉峰 大四学生");
        map.put("year", "2018");
        map.put("month", "9");
        map.put("contentAndRequirement", "ghghjhasjxjshHJHHKJKJKJKJKJK加了力考虑考虑");
        map.put("topicSelectionBasis", "不知道咋选");
        map.put("researchMean", "研究研究这些问题");
        map.put("researchPrecentSituation", "还没发现");
        map.put("researchContent", "还没研究");
        map.put("researchIdea", "暂时没有");
        map.put("researchMethod", "不了解");
        map.put("thesisProposal", "五五无无无");
        map.put("litereture", "咋写呢");
        map.put("designTop", "asfdassad");
        map.put("teacherName", "sdsdsafddddddddddd");
        map.put("chargeName", "asdegregrg");
        map.put("isAgree1", "asdsdfdf");
        map.put("isAgree2", "asdsdfdf");
        configuration.setClassForTemplateLoading(this.getClass(), "./template/");
        Template template = configuration.getTemplate("word.ftl");
        File outFile = new File("D:" + File.separator + "test.doc");
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        //数据填充到模板中
        template.process(map, writer);
    }

    //图片编码转化
    private String getImageStr(String imgUrl) throws Exception{
        InputStream inputStream = new FileInputStream(imgUrl);
        byte[] data = null;
        data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
