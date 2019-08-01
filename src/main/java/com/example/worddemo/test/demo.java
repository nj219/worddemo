/*
package com.example.worddemo.test;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
 
import javax.imageio.ImageIO;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class demo {
	private static int blank = 5;

	public static void main(String[] args) {
		try {
			// 获取所有图片
			List<String> list = new ArrayList<>();
			list.add("F:\\file\\4aba.emf");

			addPdfMark("F:\\2.pdf", "F:\\2.pdf", list);
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		System.out.println("成功");
	}

	public static void addPdfMark(String InPdfFile, String outPdfFile, List<String> imgList) throws Exception {
		try {
			// 获取PDF文档信息
			Map<String, Object> pdfMsg = getPdfMsg(InPdfFile);
			// 开始计算图片起始位置 * PDF文档宽度 - （所有图片的宽度 + 每张图片右侧加5 个单位的空白 ）
			float startAddress = Float.valueOf(pdfMsg.get("width").toString());
			for (String imgPath : imgList) {
				*/
/*startAddress -= (Double.valueOf(getImgMsg(imgPath).get("width").toString()) + blank);*//*

			}

			PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPdfFile));

			for (String imgPath : imgList) {
				Image img = Image.getInstance(imgPath);// 插入水印   
				// 设置图片水印的位置。
				img.setAbsolutePosition(startAddress, 400);
				// 开始水印 如果需要每一页都加图片，这里添加循环即可
				PdfContentByte under = stamp.getUnderContent(Integer.valueOf(pdfMsg.get("pageSize").toString()));
				under.addImage(img);
				*/
/*startAddress += Float.valueOf(Float.valueOf(getImgMsg(imgPath).get("width").toString()) + blank);*//*

			}

			stamp.close();// 关闭          
			File tempfile = new File(InPdfFile);

			if (tempfile.exists()) {
				tempfile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Object> getPdfMsg(String filePath) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			// 获取PDF共有几页
			PdfReader pdfReader = new PdfReader(new FileInputStream(filePath));
			int pages = pdfReader.getNumberOfPages();
			// System.err.println(pages);
			map.put("pageSize", pages);

			// 获取PDF 的宽高
			PdfReader pdfreader = new PdfReader(filePath);
			Document document = new Document(pdfreader.getPageSize(pages));
			float widths = document.getPageSize().getWidth();
			// 获取页面高度
			float heights = document.getPageSize().getHeight();
			// System.out.println("widths = " + widths + ", heights = " + heights);
			map.put("width", widths);
			map.put("height", heights);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, Object> getImgMsg(String imgPath) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			File picture = new File(imgPath);
			BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
			// System.out.println("=源图宽度===>"+sourceImg.getWidth()); // 源图宽度
			// System.out.println("=源图高度===>"+sourceImg.getHeight()); // 源图高度

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
 
}*/
