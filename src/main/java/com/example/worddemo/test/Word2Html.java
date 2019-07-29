package com.example.worddemo.test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.persistence.Convert;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.hslf.blip.EMF;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.HeaderStories;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFRenderer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

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
            convert2Html("F:\\tt.doc", "f:\\file\\1.html");
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
        String text = node.text().replaceAll("\r|\n|\\s","");

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
            String src= element.attr("src");

            if (src.endsWith("emf")) {

            }
        }


        //遍历取出所有a标签，解析href，替换为自己的接口,访问接口去数据库对比是否存在文件
        Elements e = doc.select("a");
        for (int i = 0; i < e.size(); i++) {
            Element anode = e.get(i);
            String href= anode.attr("href");

            if (href.startsWith("http") || href.startsWith("https")) {

            } else {
                try {
                    href= URLDecoder.decode(href,"UTF-8");
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                String[] split = href.split("/");
                String s = split[split.length - 1];

                href = "http://localhost/test/wordDoc/?word="+s; //修改style中的url值
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
                PictureType bmp = PictureType.BMP;
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
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();

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




    public static void emfConversionPng(List<String> list) throws IOException {
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
                            saveUrl.substring(saveUrl.length() - 3), "jpg");
                    File outputfile = new File(url);
                    // 写入到磁盘中(格式设置为png背景不会变为橙色)
                    boolean png = ImageIO.write(result, "jpg", outputfile);
                    // 当前的图片写入到磁盘中后，将流关闭
                    if (eis != null) {
                        eis.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } else if (saveUrl.contains("wmf") || saveUrl.contains("WMF")) {
                    /*// 将wmf转svg
                    String svgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".svg";
                    wmfToSvg(saveUrl, svgFile);
                    // 将svg转png
                    String jpgFile = saveUrl.substring(0,
                            saveUrl.lastIndexOf(".wmf"))
                            + ".png";
                    svgToJpg(svgFile, jpgFile);*/
                }
            }
        }
    }

}
