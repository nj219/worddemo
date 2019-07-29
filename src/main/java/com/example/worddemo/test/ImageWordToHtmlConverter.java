package com.example.worddemo.test;

import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

/**
 * 处理doc文件转换html时的图片显示
 *
 */
public class ImageWordToHtmlConverter extends WordToHtmlConverter {

    public ImageWordToHtmlConverter(Document document) {
        super(document);
    }

    @Override
    protected void processImageWithoutPicturesManager(Element currentBlock,
                                                      boolean inlined, Picture picture) {
        Element imgNode = currentBlock.getOwnerDocument().createElement("img");
        StringBuilder sb = new StringBuilder();
        sb.append(java.util.Base64.getMimeEncoder().encodeToString(picture.getRawContent()));
        sb.insert(0, "data:" + picture.getMimeType() + ";base64,");
        imgNode.setAttribute("src", sb.toString());
        currentBlock.appendChild(imgNode);
    }

}