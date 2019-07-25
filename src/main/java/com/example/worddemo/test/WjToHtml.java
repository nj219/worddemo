/*
package com.example.worddemo.test;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpbf.model.MainContents;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;




public class WjToHtml {
	public static void main(String[] args) throws Exception{
		String type=".doc";
		String htmlPath="html字符串";
		String fullfilepath="F:\\tt.doc";
		String htmlFile="F:\\1.html";
		String downloadfilename="tt";
		if (".doc".equals(type)) {
			String parTh="/";
			//TODO
			htmlPath=docToHtml(fullfilepath, htmlFile, parTh);
		} else if (".docx".equals(type)) {// 文档
			// TODO
			htmlPath=docx2Html(fullfilepath,htmlFile);
		} else if (".xls".equals(type) || ".xlsx".equals(type)) {// 表格
			//htmlPath = excelToHtml(fullfilepath, downloadfilename);
		} else if (".txt".equals(type)) {// txt
			htmlPath = "<!DOCTYPE html><html><head><title>" + downloadfilename + "</title><body><div>"
					+ readFileToString(fullfilepath, "txt") + "</div></body></html>";
		} else if (isImag(new File(fullfilepath))) {// 图片
			htmlPath = "<!DOCTYPE html><html><head><title>" + downloadfilename + "</title><body><div><img src='"
					+ fullfilepath + "'/></div></body></html>";

		}
	}
	
	*/
/**
	 * docx格式word转换为html
	 *
	 * @param fileName   docx文件路径
	 * @param outPutFile html输出文件路径
	 * @throws TransformerException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 *//*

	public static String docx2Html(String docFile, String htmlFIle) throws IOException {
		// FontsDocument$Factory;
		String fileOutName = htmlFIle;
		long startTime = System.currentTimeMillis();
		XWPFDocument document = new XWPFDocument(new FileInputStream(docFile));
		XHTMLOptions options = XHTMLOptions.create().indent(4);
		// 导出图片
		File imageFolder = new File("E:/temp/images");
		options.setExtractor(new FileImageExtractor(imageFolder));
		// URI resolver word的html中图片的目录路径
		options.URIResolver(new BasicURIResolver("images"));
		File outFile = new File(fileOutName);
		outFile.getParentFile().mkdirs();
		OutputStream out = new FileOutputStream(outFile);
		// org.apache.poi.xwpf.converter.xhtml.XHTMLConverter.convert.XHTMLConverter.java:72
		XHTMLConverter.getInstance().convert(document, out, options);
		*/
/*FileInputStream fs = new FileInputStream(fileOutName);
		byte[] buf = new byte[4096];
		int readLength;
		String htmls = "";
		while (((readLength = fs.read(buf)) != -1)) {
			//htmls += (char)readLength;
			System.out.write(buf, 0, readLength);  
		}*//*

		//fileOutName
		String htmls=readFileToString(fileOutName,"html");
	//	System.out.println("Generate " + htmls + " with " + (System.currentTimeMillis() - startTime) + " ms.");

		return htmls;
	}
	
	*/
/**
	 * 将doc转成html
	 * @param path
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 *//*

	private static  String docToHtml( String docFile,String htmlFile,String htmlPath)
			throws FileNotFoundException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		InputStream input = new FileInputStream(docFile);
		//XWPFDocument xw = new XWPFDocument(input);
		HWPFDocument wordDocument = new HWPFDocument(input);
		// https://view.officeapps.live.com/op/view.aspx?src=http://10.98.0.38:8080/bpm/r?wf_num=rule?wf_num=R_S004_B004&filenum=9b5564dd07aab045090ac9b03cf0a443fb00

		// WordToHtmlConverter
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
			public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches,
					float heightInches) {
				return suggestedName;
			}
		});
		wordToHtmlConverter.processDocument(wordDocument);
		List pics = wordDocument.getPicturesTable().getAllPictures();
		if (pics != null) {
			for (int i = 0; i < pics.size(); i++) {
				Picture pic = (Picture) pics.get(i);
				try {
					pic.writeImageContent(new FileOutputStream(htmlPath + pic.suggestFullFileName()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		Document htmlDocument = wordToHtmlConverter.getDocument();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(outStream);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		outStream.close();
		String content = new String(outStream.toByteArray());
		FileUtils.writeStringToFile(new File(htmlFile), content, "utf-8");
		
		String htmls=readFileToString(htmlFile,"html");
		//	System.out.println("Generate " + htmls + " with " + (System.currentTimeMillis() - startTime) + " ms.");

		return htmls;
	}

	*/
/**
	 * 判断是否是图片文件
	 * 
	 * @param file
	 * @return
	 *//*

	public static boolean isImag(File file) {
		BufferedImage image = null;
		Boolean fg = true;
		try {
			image = ImageIO.read(file);
			if (image == null) {
				fg = false;
			}
		} catch (IOException ex) {
			fg = false;
		}

		return fg;
	}

	

	*/
/**
	 * 读取文件为字符串
	 * 
	 * @param path
	 * @param type
	 * @return
	 *//*

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

	*/
/**
	 * excelTohtml方法
	 * 
	 * @param fileName
	 * @param path
	 *//*

	*/
/*private static String excelToHtml(String fileName, String path) {
		InputStream is = null;
		String htmlExcel = null;
		try {
			File sourcefile = new File(path);
			is = new FileInputStream(sourcefile);
			Workbook wb = WorkbookFactory.create(is);// 此WorkbookFactory在POI-3.10版本中使用需要添加dom4j
			if (wb instanceof XSSFWorkbook) {
				XSSFWorkbook xWb = (XSSFWorkbook) wb;
				htmlExcel = getExcelInfo(xWb, true);
			} else if (wb instanceof HSSFWorkbook) {
				HSSFWorkbook hWb = (HSSFWorkbook) wb;
				htmlExcel = getExcelInfo(hWb, true);
			}
			htmlExcel = "<!DOCTYPE html><html><head><title>" + fileName + "</title><body><div>" + htmlExcel
					+ "</div></body></html>";
			return htmlExcel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*//*


	*/
/**
	 * 程序入口方法
	 * 
	 * @param filePath    文件的路径
	 * @param isWithStyle 是否需要表格样式 包含 字体 颜色 边框 对齐方式
	 * @return
	 *         <table>
	 *         ...
	 *         </table>
	 *         字符串
	 *//*

	*/
/*public String readExcelToHtml(String filePath, boolean isWithStyle) {

		InputStream is = null;
		String htmlExcel = null;
		try {
			File sourcefile = new File(filePath);
			is = new FileInputStream(sourcefile);
			Workbook wb = WorkbookFactory.create(is);
			if (wb instanceof XSSFWorkbook) {
				XSSFWorkbook xWb = (XSSFWorkbook) wb;
				htmlExcel = getExcelInfo(xWb, isWithStyle);
			} else if (wb instanceof HSSFWorkbook) {
				HSSFWorkbook hWb = (HSSFWorkbook) wb;
				htmlExcel = getExcelInfo(hWb, isWithStyle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return htmlExcel;
	}*//*


	*/
/**
	 * 将excel内容转成html
	 * 
	 * @param wb
	 * @param isWithStyle
	 * @return
	 *//*

	public static String getExcelInfo(Workbook wb, boolean isWithStyle) {

		StringBuffer sb = new StringBuffer();
		Sheet sheet = wb.getSheetAt(0);// 获取第一个Sheet的内容
		int lastRowNum = sheet.getLastRowNum();
		Map<String, String> map[] = getRowSpanColSpanMap(sheet);
		sb.append("<table style='border-collapse:collapse;' width='100%'>");
		Row row = null; // 兼容
		Cell cell = null; // 兼容

		for (int rowNum = sheet.getFirstRowNum(); rowNum <= lastRowNum; rowNum++) {
			row = sheet.getRow(rowNum);
			if (row == null) {
				sb.append("<tr><td > &nbsp;</td></tr>");
				continue;
			}
			sb.append("<tr>");
			int lastColNum = row.getLastCellNum();
			for (int colNum = 0; colNum < lastColNum; colNum++) {
				cell = row.getCell(colNum);
				if (cell == null) { // 特殊情况 空白的单元格会返回null
					sb.append("<td>&nbsp;</td>");
					continue;
				}

				String stringValue = getCellValue(cell);
				if (map[0].containsKey(rowNum + "," + colNum)) {
					String pointString = map[0].get(rowNum + "," + colNum);
					map[0].remove(rowNum + "," + colNum);
					int bottomeRow = Integer.valueOf(pointString.split(",")[0]);
					int bottomeCol = Integer.valueOf(pointString.split(",")[1]);
					int rowSpan = bottomeRow - rowNum + 1;
					int colSpan = bottomeCol - colNum + 1;
					sb.append("<td rowspan= '" + rowSpan + "' colspan= '" + colSpan + "' ");
				} else if (map[1].containsKey(rowNum + "," + colNum)) {
					map[1].remove(rowNum + "," + colNum);
					continue;
				} else {
					sb.append("<td ");
				}

				// 判断是否需要样式
				if (isWithStyle) {
					dealExcelStyle(wb, sheet, cell, sb);// 处理单元格样式
				}

				sb.append(">");
				if (stringValue == null || "".equals(stringValue.trim())) {
					sb.append(" &nbsp; ");
				} else {
					// 将ascii码为160的空格转换为html下的空格（&nbsp;）
					sb.append(stringValue.replace(String.valueOf((char) 160), "&nbsp;"));
				}
				sb.append("</td>");
			}
			sb.append("</tr>");
		}

		sb.append("</table>");
		return sb.toString();
	}

	private static Map<String, String>[] getRowSpanColSpanMap(Sheet sheet) {

		Map<String, String> map0 = new HashMap<String, String>();
		Map<String, String> map1 = new HashMap<String, String>();
		int mergedNum = sheet.getNumMergedRegions();
		CellRangeAddress range = null;
		for (int i = 0; i < mergedNum; i++) {
			range = sheet.getMergedRegion(i);
			int topRow = range.getFirstRow();
			int topCol = range.getFirstColumn();
			int bottomRow = range.getLastRow();
			int bottomCol = range.getLastColumn();
			map0.put(topRow + "," + topCol, bottomRow + "," + bottomCol);
			// System.out.println(topRow + "," + topCol + "," + bottomRow + "," +
			// bottomCol);
			int tempRow = topRow;
			while (tempRow <= bottomRow) {
				int tempCol = topCol;
				while (tempCol <= bottomCol) {
					map1.put(tempRow + "," + tempCol, "");
					tempCol++;
				}
				tempRow++;
			}
			map1.remove(topRow + "," + topCol);
		}
		Map[] map = { map0, map1 };
		return map;
	}

	*/
/**
	 * 获取表格单元格Cell内容
	 * 
	 * @param cell
	 * @return
	 *//*

	private static String getCellValue(Cell cell) {

		String result = new String();
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:// 数字类型
			if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
				SimpleDateFormat sdf = null;
				if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
					sdf = new SimpleDateFormat("HH:mm");
				} else {// 日期
					sdf = new SimpleDateFormat("yyyy-MM-dd");
				}
				Date date = cell.getDateCellValue();
				result = sdf.format(date);
			} else if (cell.getCellStyle().getDataFormat() == 58) {
				// 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				double value = cell.getNumericCellValue();
				Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
				result = sdf.format(date);
			} else {
				double value = cell.getNumericCellValue();
				CellStyle style = cell.getCellStyle();
				DecimalFormat format = new DecimalFormat();
				String temp = style.getDataFormatString();
				// 单元格设置成常规
				if (temp.equals("General")) {
					format.applyPattern("#");
				}
				result = format.format(value);
			}
			break;
		case Cell.CELL_TYPE_STRING:// String类型
			result = cell.getRichStringCellValue().toString();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
			break;
		default:
			result = "";
			break;
		}
		return result;
	}

	*/
/**
	 * 处理表格样式
	 * 
	 * @param wb
	 * @param sheet
	 * @param cell
	 * @param sb
	 *//*

	private static void dealExcelStyle(Workbook wb, Sheet sheet, Cell cell, StringBuffer sb) {

		CellStyle cellStyle = cell.getCellStyle();
		if (cellStyle != null) {
			short alignment = cellStyle.getAlignment();
			sb.append("align='" + convertAlignToHtml(alignment) + "' ");// 单元格内容的水平对齐方式
			short verticalAlignment = cellStyle.getVerticalAlignment();
			sb.append("valign='" + convertVerticalAlignToHtml(verticalAlignment) + "' ");// 单元格中内容的垂直排列方式

			if (wb instanceof XSSFWorkbook) {

				XSSFFont xf = ((XSSFCellStyle) cellStyle).getFont();
				short boldWeight = xf.getBoldweight();
				sb.append("style='");
				sb.append("font-weight:" + boldWeight + ";"); // 字体加粗
				sb.append("font-size: " + xf.getFontHeight() / 2 + "%;"); // 字体大小
				int columnWidth = sheet.getColumnWidth(cell.getColumnIndex());
				sb.append("width:" + columnWidth + "px;");

				XSSFColor xc = xf.getXSSFColor();
				if (xc != null && !"".equals(xc)) {
					sb.append("color:#" + xc.getARGBHex().substring(2) + ";"); // 字体颜色
				}

				XSSFColor bgColor = (XSSFColor) cellStyle.getFillForegroundColorColor();
				// System.out.println("************************************");
				// System.out.println("BackgroundColorColor:
				// "+cellStyle.getFillBackgroundColorColor());
				// System.out.println("ForegroundColor:
				// "+cellStyle.getFillForegroundColor());//0
				// System.out.println("BackgroundColorColor:
				// "+cellStyle.getFillBackgroundColorColor());
				// System.out.println("ForegroundColorColor:
				// "+cellStyle.getFillForegroundColorColor());
				// String bgColorStr = bgColor.getARGBHex();
				// System.out.println("bgColorStr: "+bgColorStr);
				if (bgColor != null && !"".equals(bgColor)) {
					sb.append("background-color:#" + bgColor.getARGBHex().substring(2) + ";"); // 背景颜色
				}
				sb.append(getBorderStyle(0, cellStyle.getBorderTop(),
						((XSSFCellStyle) cellStyle).getTopBorderXSSFColor()));
				sb.append(getBorderStyle(1, cellStyle.getBorderRight(),
						((XSSFCellStyle) cellStyle).getRightBorderXSSFColor()));
				sb.append(getBorderStyle(2, cellStyle.getBorderBottom(),
						((XSSFCellStyle) cellStyle).getBottomBorderXSSFColor()));
				sb.append(getBorderStyle(3, cellStyle.getBorderLeft(),
						((XSSFCellStyle) cellStyle).getLeftBorderXSSFColor()));

			} else if (wb instanceof HSSFWorkbook) {

				HSSFFont hf = ((HSSFCellStyle) cellStyle).getFont(wb);
				short boldWeight = hf.getBoldweight();
				short fontColor = hf.getColor();
				sb.append("style='");
				HSSFPalette palette = ((HSSFWorkbook) wb).getCustomPalette(); // 类HSSFPalette用于求的颜色的国际标准形式
				HSSFColor hc = palette.getColor(fontColor);
				sb.append("font-weight:" + boldWeight + ";"); // 字体加粗
				sb.append("font-size: " + hf.getFontHeight() / 2 + "%;"); // 字体大小
				String fontColorStr = convertToStardColor(hc);
				if (fontColorStr != null && !"".equals(fontColorStr.trim())) {
					sb.append("color:" + fontColorStr + ";"); // 字体颜色
				}
				int columnWidth = sheet.getColumnWidth(cell.getColumnIndex());
				sb.append("width:" + columnWidth + "px;");
				short bgColor = cellStyle.getFillForegroundColor();
				hc = palette.getColor(bgColor);
				String bgColorStr = convertToStardColor(hc);
				if (bgColorStr != null && !"".equals(bgColorStr.trim())) {
					sb.append("background-color:" + bgColorStr + ";"); // 背景颜色
				}
				sb.append(getBorderStyle(palette, 0, cellStyle.getBorderTop(), cellStyle.getTopBorderColor()));
				sb.append(getBorderStyle(palette, 1, cellStyle.getBorderRight(), cellStyle.getRightBorderColor()));
				sb.append(getBorderStyle(palette, 3, cellStyle.getBorderLeft(), cellStyle.getLeftBorderColor()));
				sb.append(getBorderStyle(palette, 2, cellStyle.getBorderBottom(), cellStyle.getBottomBorderColor()));
			}

			sb.append("' ");
		}
	}

	*/
/**
	 * 单元格内容的水平对齐方式
	 * 
	 * @param alignment
	 * @return
	 *//*

	private static String convertAlignToHtml(short alignment) {

		String align = "left";
		switch (alignment) {
		case CellStyle.ALIGN_LEFT:
			align = "left";
			break;
		case CellStyle.ALIGN_CENTER:
			align = "center";
			break;
		case CellStyle.ALIGN_RIGHT:
			align = "right";
			break;
		default:
			break;
		}
		return align;
	}

	*/
/**
	 * 单元格中内容的垂直排列方式
	 * 
	 * @param verticalAlignment
	 * @return
	 *//*

	private static String convertVerticalAlignToHtml(short verticalAlignment) {

		String valign = "middle";
		switch (verticalAlignment) {
		case CellStyle.VERTICAL_BOTTOM:
			valign = "bottom";
			break;
		case CellStyle.VERTICAL_CENTER:
			valign = "center";
			break;
		case CellStyle.VERTICAL_TOP:
			valign = "top";
			break;
		default:
			break;
		}
		return valign;
	}

	private static String convertToStardColor(HSSFColor hc) {

		StringBuffer sb = new StringBuffer("");
		if (hc != null) {
			if (HSSFColor.AUTOMATIC.index == hc.getIndex()) {
				return null;
			}
			sb.append("#");
			for (int i = 0; i < hc.getTriplet().length; i++) {
				sb.append(fillWithZero(Integer.toHexString(hc.getTriplet()[i])));
			}
		}

		return sb.toString();
	}

	private static String fillWithZero(String str) {
		if (str != null && str.length() < 2) {
			return "0" + str;
		}
		return str;
	}

	static String[] bordesr = { "border-top:", "border-right:", "border-bottom:", "border-left:" };
	static String[] borderStyles = { "solid ", "solid ", "solid ", "solid ", "solid ", "solid ", "solid ", "solid ",
			"solid ", "solid", "solid", "solid", "solid", "solid" };

	private static String getBorderStyle(HSSFPalette palette, int b, short s, short t) {

		if (s == 0)
			return bordesr[b] + borderStyles[s] + "#d0d7e5 1px;";
		;
		String borderColorStr = convertToStardColor(palette.getColor(t));
		borderColorStr = borderColorStr == null || borderColorStr.length() < 1 ? "#000000" : borderColorStr;
		return bordesr[b] + borderStyles[s] + borderColorStr + " 1px;";

	}

	private static String getBorderStyle(int b, short s, XSSFColor xc) {

		if (s == 0)
			return bordesr[b] + borderStyles[s] + "#d0d7e5 1px;";
		;
		if (xc != null && !"".equals(xc)) {
			String borderColorStr = xc.getARGBHex();// t.getARGBHex();
			borderColorStr = borderColorStr == null || borderColorStr.length() < 1 ? "#000000"
					: borderColorStr.substring(2);
			return bordesr[b] + borderStyles[s] + borderColorStr + " 1px;";
		}

		return "";
	}

}
*/
