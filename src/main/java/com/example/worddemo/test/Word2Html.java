package com.example.worddemo.test;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.sun.javaws.jnl.XMLFormat;
import fr.opensagres.xdocreport.converter.docx.poi.xhtml.XWPF2XHTMLConverter;
import lombok.val;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.HeaderStories;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.ZipPackagePart;
import org.apache.poi.poifs.property.Child;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

/**
 * @author: 牛杰
 * @since: May 3, 2012
 * @modified: May 3, 2012
 * @version:
 */
@Slf4j
@Component
public class Word2Html {

    public static void main(String arg[]) throws Exception {

        try {
            //convert2Html("F:\\dd.doc", "f:\\file\\1.html");
            docx2Html("F:/tt.docx","F:/docx.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String content, String path, String header) {
        //利用jsoup解析HTML
        org.jsoup.nodes.Document doc = Jsoup.parse(content);

        //取出职责内容,存库对应关系
        /*String text = doc.text();
        String s1 = text.split("Responsibilities 职责")[1];

        String s2 = s1.split("5.1")[0];
        System.out.println(s2);*/


        Elements table = doc.getElementsByTag("table");

        Elements div = doc.getElementsByTag("div");

        Element node = table.get(table.size() - 1);

        //获取解析后的页眉，与之前做对比，如果相同，则提取
        String text = node.text().replaceAll("\\s", "");

        String s1 = header.replaceAll("\\s", "").replaceAll("\r", "");

        /*log.info(s1);
        log.info("==========================================");
        log.info(text);*/

        /*System.out.println(text.equals(header));*/


        //System.out.println(node);
        //把页眉替换到头部
        Element child = div.first().child(0);
        child.before(node.toString());
        //删除多余页眉
        node.remove();

        //遍历取出图片
        Elements img = doc.select("img");
        for (Element element : img) {
            String src = element.attr("src");

            if (src.endsWith("emf")) {

            }
        }


        //遍历取出所有a标签，解析href，替换为自己的接口,访问接口去数据库对比是否存在文件
        Elements e = doc.select("a");
        for (int i = 0; i < e.size(); i++) {
            Element anode = e.get(i);
            String href = anode.attr("href");

            if (href.startsWith("http") || href.startsWith("https")) {

            } else {
                try {
                    href = URLDecoder.decode(href, "UTF-8");
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                String[] split = href.split("/");
                String s = split[split.length - 1];

                href = "http://localhost/test/wordDoc/?word=" + s; //修改style中的url值
            }


            anode.attr("href", href);
        }

        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));

            bw.write(doc.toString());
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
    }

    /**
     * 解析doc
     *
     * @param fileName
     * @param outPutFile
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static void convert2Html(String fileName, String outPutFile)
            throws TransformerException, IOException,
            ParserConfigurationException {
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));

        //WordToHtmlUtils.loadDoc(new FileInputStream(inputFile));
        HeaderStories headerStories = new HeaderStories(wordDocument);
        String header = headerStories.getHeader(1);


        /*StringBuilder text = wordDocument.getText();*/

        PicturesTable picturesTable = wordDocument.getPicturesTable();
        List<Picture> allPictures = picturesTable.getAllPictures();

        for (Picture allPicture : allPictures) {
            String mimeType = allPicture.getMimeType();
            PictureType pictureType = allPicture.suggestPictureType();
            byte[] rawContent = allPicture.getRawContent();

            String s = UtilHelper.byte2Base64StringFun(rawContent);

            System.out.println();
        }

        /*StringBuilder text = wordDocument.getText();

        int x = text.indexOf("Responsibilities 职责");

        String[] split = text.toString().split("Responsibilities");
        String s = split[1].split("5.1")[0];  //可能没有

        log.info(s);*/

        /*File file = new File("F:\\2.txt");
        Writer o = new OutputStreamWriter(new FileOutputStream(file));
        o.write(s);
        o.close();*/

        Range overallRange = wordDocument.getOverallRange(); //页眉页脚

        System.out.println(wordDocument);


        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());

        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content,
                                      PictureType pictureType, String suggestedName,
                                      float widthInches, float heightInches) {
                String mime = pictureType.getMime();


                return "" + suggestedName;
            }
        });


        wordToHtmlConverter.processDocumentPart(wordDocument, overallRange);
//        wordToHtmlConverter.processDocument(wordDocument);

        //save pictures
        List pics = wordDocument.getPicturesTable().getAllPictures();
        if (pics != null) {
            for (int i = 0; i < pics.size(); i++) {
                Picture pic = (Picture) pics.get(i);
                String mimeType = pic.getMimeType();
                System.out.println(pic);

                try {
                    pic.writeImageContent(new FileOutputStream("F:/file/"
                            + pic.suggestFullFileName()));

                    /*List<String> list = new ArrayList<>();
                    list.add("F:/file/" + pic.suggestFullFileName());
                    emfConversionPng(list);*/

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        Document htmlDocument = wordToHtmlConverter.getDocument();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        writeFile(new String(out.toByteArray()), outPutFile, header);
    }

    /**
     * 解析docx
     *
     * @param fileName   文件名称
     * @param outPutFile 输出路径
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String docx2Html(String fileName, String outPutFile) throws TransformerException, IOException,
            ParserConfigurationException {
        String fileOutName = outPutFile;
        long startTime = System.currentTimeMillis();
        XWPFDocument document = new XWPFDocument(new FileInputStream(fileName));
        XHTMLOptions options = XHTMLOptions.create();

        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);

        //页眉页脚
        XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
        XWPFHeader header = headerFooterPolicy.getDefaultHeader();  //页眉
        XWPFFooter footer = headerFooterPolicy.getDefaultFooter();  //页脚

        //页眉
        List<XWPFTable> headerTables = header.getTables();
        for (XWPFTable table : headerTables) {
            //页眉解析
            CTTbl ctTbl = table.getCTTbl();    //xml格式

            String s = ctTbl.toString();

            //解析xml后返回的HTML数据
            String form = parsingXML(s);

            //解析HTML替换某些参数
            org.jsoup.nodes.Document parse = Jsoup.parse(form);
            Elements div = parse.select("div");

            div.get(2).attr("style","display: inline-block;border-right:1px solid #000;padding-right: 50px");
            String text = div.get(3).text();
            div.get(3).attr("style","display: inline-block;text-align: right;float: right");
            div.get(2).appendElement("img style=\"width:1.8988042in;height:0.4295625in;vertical-align:text-bottom;\" src=\"639c.png\"");

            Elements span = parse.select("span");
            span.get(1).attr("style", "text-align: right;font-family: 宋体;font-weight: bold;");
            span.get(0).attr("style", "text-align: right;font-family: Times New Roman;font-weight: bold;");
            for (Element pan : span) {
                if (pan.text().equals("□")) {
                    pan.attr("style", "font-family: 宋体;float: left; display: block;");
                }
            }

            //XHTMLConverter.getInstance().convert(part, new FileOutputStream("F:\\file\\1.html"), options);
            System.out.println();
        }

        //页脚
        List<XWPFTable> footerTables = footer.getTables();
        String text = footer.getText();
        XWPFFooter footerArray = document.getFooterArray(0);
        CTHdrFtr ctHdrFtr = footerArray._getHdrFtr();  //页脚xml

        String footerHtml = footerParsing(ctHdrFtr.toString());



        //导出页眉图片
        List<XWPFPictureData> allPictures = header.getAllPictures();
        int size = allPictures.size();
        if (size >0) {
            for (XWPFPictureData picture : allPictures) {
                byte[] data = picture.getData();
                new FileOutputStream("F:\\file"+picture.getFileName()).write(data);
            }
        }

        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            String paragraphText = paragraph.getText();
            System.out.println();
        }


        //导出图片
        File imageFolder = new File("F:/file");
        options.setExtractor(new FileImageExtractor(imageFolder));
        // URI resolver word的html中图片的目录路径
        options.URIResolver(new BasicURIResolver("images"));

        File outFile = new File(fileOutName);
        outFile.getParentFile().mkdirs();
        OutputStream out = new FileOutputStream(outFile);
        // org.apache.poi.xwpf.converter.xhtml.XHTMLConverter.convert.XHTMLConverter.java:72
        XHTMLConverter.getInstance().convert(document, out, options);

        FileInputStream fs = new FileInputStream(fileOutName);
        byte[] buf = new byte[4096];
        int readLength;
        String htmls = "";
        while (((readLength = fs.read(buf)) != -1)) {
            htmls += (char)readLength;
            //System.out.write(buf, 0, readLength);
        }

        //fileOutName
        htmls = readFileToString(fileOutName, "html");
        //	System.out.println("Generate " + htmls + " with " + (System.currentTimeMillis() - startTime) + " ms.");

        return htmls;
    }

    /**
     * 解析页脚xml
     * @param footer
     * @return
     */
    private static String footerParsing(String footer) {
        String html = "";
        org.jsoup.nodes.Document doc = Jsoup.parse(footer);

        Elements wp = doc.getElementsByTag("w:p");

        for (Element p : wp) {
            html += "<p>";
            Elements wr = p.getElementsByTag("w:r");
            for (Element r : wr) {
                Elements wrpr = r.getElementsByTag("w:rPr");
                Elements wt = r.getElementsByTag("w:t");

                String font = "";
                String color = "";
                for (Element rpr : wrpr) {
                    Elements wrfonts = rpr.getElementsByTag("w:rFonts");
                    font = wrfonts.get(0).attr("w:hAnsi");

                    Elements wcolor = rpr.getElementsByTag("w:color");
                    color = wcolor.get(0).attr("w:val");
                }

                for (Element t : wt) {
                    html += "<span style='font-family: " + font + ";color: #" + color + "'>" + t.text() + "</span>";
                }
            }
            html += "</p>";
        }

        return html;
    }

    /**
     * 解析页眉xml
     * @param s
     * @return
     */
    private static String parsingXML(String s) {
        String html = "";
        org.jsoup.nodes.Document doc = Jsoup.parse(s);

        Elements wtr = doc.getElementsByTag("w:tr");

        ArrayList<Integer> tList = new ArrayList();
        int total = 0;

        html += "<div style=\"margin: 0 auto; display:inline-block;\">";
        for (Element tr : wtr) {
            html += "<div style=\"border:1px solid #000\">";
            Elements wtc = tr.getElementsByTag("w:tc");
            for (Element tc : wtc) {
                html += "<div style=\"display: inline-block;border-left:1px solid #000;padding-right: 50px\">";
                total++;
                Elements wp = tc.getElementsByTag("w:p");
                for (Element p : wp) {
                    Elements wr = p.getElementsByTag("w:r");
                    Elements wppr = p.getElementsByTag("w:pPr");

                    String attrwjc = "";
                    for (Element ppr : wppr) {
                        Elements wjc = ppr.getElementsByTag("w:jc");

                        if (!wjc.isEmpty()) {
                            for (Element jc : wjc) {
                                attrwjc = jc.attr("w:val");
                            }
                        }
                    }

                    for (Element r : wr) {
                        Elements wt = r.getElementsByTag("w:t");
                        Elements wrpr = r.getElementsByTag("w:rPr");

                        String attrfont = "";
                        String eleWb = "";
                        String eleWbcs = "";
                        for (Element rpr : wrpr) {
                            Elements wrfont = rpr.getElementsByTag("w:rFonts");
                            Elements wb = rpr.getElementsByTag("w:b");
                            Elements wbcs = rpr.getElementsByTag("w:bCs");

                            for (Element rfont : wrfont) {
                                attrfont = "font-family: " + rfont.attr("w:hAnsi") + ";";
                            }

                            if (!wb.isEmpty()) {
                                eleWb = "font-weight: bold;";
                            }

                            if (!wbcs.isEmpty()) {
                                eleWbcs = "<br />";
                            }
                        }

                        for (Element t : wt) {
                            if (attrwjc != "") {
                                html += eleWbcs + "<span style='float: left; display: block; text-align: "+attrwjc + ";" + attrfont + eleWb + "'>" + t.text() + "</span>";
                            } else {
                                html += eleWbcs + "<span style=\"float: left; display: block;" + attrfont + eleWb  + "\">" + t.text() + "</span>";
                            }


                        }

                    }
                }
                html += "</div>";
            }
            tList.add(total);
            total = 0;
            html += "</div>";
        }
        html += "</div>";
        return html;
    }

    public static String readFileToString(String path, String type) {
        // 定义返回结果
        String jsonString = "";
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));// 读取文件
            String thisLine = null;
            while ((thisLine = in.readLine()) != null) {
                sb.append(thisLine);
                if ("txt".equals(type))
                    sb.append("<br/>");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException el) {
                }
            }
        }
        jsonString = sb.toString();
        // 返回拼接好的JSON String
        return jsonString;
    }

    /*public static void emfConversionPng(List<String> list) throws IOException {
        if (list.size() > 0) {
            // 对文件的命名进行重新修改
            for (int i = 0; i < list.size(); i++) {
                String saveUrl = list.get(i);
                // 从doc文档解析的图片很有可能已经是png了，所以此处需要判断
                if (saveUrl.contains("emf") || saveUrl.contains("EMF")) {
                    InputStream is = new FileInputStream(saveUrl);
                    EMFInputStream eis = new EMFInputStream(is,
                            EMFInputStream.DEFAULT_VERSION);
                    EMFRenderer emfRenderer = new EMFRenderer(eis);
                    final int width = (int) eis.readHeader().getBounds()
                            .getWidth();
                    final int height = (int) eis.readHeader().getBounds()
                            .getHeight();
                    // 设置图片的大小和样式
                    final BufferedImage result = new BufferedImage(width,
                            height, BufferedImage.TYPE_4BYTE_ABGR);
                    Graphics2D g2 = (Graphics2D) result.createGraphics();
                    emfRenderer.paint(g2);
                    String url = saveUrl.replace(
                            saveUrl.substring(saveUrl.length() - 3), "bmp");
                    File outputfile = new File(url);
                    // 写入到磁盘中(格式设置为png背景不会变为橙色)
                    boolean png = ImageIO.write(result, "bmp", outputfile);
                    // 当前的图片写入到磁盘中后，将流关闭
                    if (eis != null) {
                        eis.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } else if (saveUrl.contains("wmf") || saveUrl.contains("WMF")) {
                    // 将wmf转svg
                    String svgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".svg";
                    wmfToSvg(saveUrl, svgFile);
                    // 将svg转png
                    String jpgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".png";
                    svgToJpg(svgFile, jpgFile);
                }
            }
        }
    }*/

}
