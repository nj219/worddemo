package com.example.worddemo.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName testWord
 * @Author shangpinyuan06
 * @Date 2019/7/17 10:14
 * 测试获取富文本内容
 **/
@Controller
@RequestMapping("test")
public class testWord {

    @RequestMapping("test")
    @ResponseBody
    public void test(String ueditor) {
        System.out.println("qqqqqqqq");
    }

    public static void main(String[] args) {
        System.out.println(StringEscapeUtils.unescapeHtml4("<html>\n" +
                "<head>\n" +
                "<META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "<style type=\"text/css\">.b1{white-space-collapsing:preserve;}\n" +
                ".d1{margin: 1.0in 0.4722222in 0.19722222in 0.4722222in;}\n" +
                ".s1{font-weight:bold;}\n" +
                ".s2{color:black;}\n" +
                ".s3{font-weight:bold;color:black;}\n" +
                ".s4{font-family:Arial;font-size:10pt;}\n" +
                ".s5{font-family:Arial;}\n" +
                ".s6{font-family:宋体;font-weight:bold;color:black;}\n" +
                ".s7{font-size:9pt;}\n" +
                ".s8{font-weight:bold;color:blue;text-decoration:underline;}\n" +
                ".s9{font-size:14pt;}\n" +
                ".s10{color:white;}\n" +
                ".s11{font-weight:bold;color:red;}\n" +
                ".p1{text-align:start;hyphenate:auto;font-family:Times New Roman;font-size:12pt;}\n" +
                ".p2{text-align:center;hyphenate:auto;font-family:Times New Roman;font-size:10pt;}\n" +
                ".p3{margin-left:0.25in;text-align:start;hyphenate:auto;font-family:Times New Roman;font-size:12pt;}\n" +
                ".p4{text-indent:0.0034722222in;margin-left:-0.0034722222in;text-align:justify;hyphenate:auto;font-family:Times New Roman;font-size:12pt;}\n" +
                ".p5{text-align:start;hyphenate:auto;font-family:Arial;font-size:12pt;}\n" +
                ".p6{text-align:start;hyphenate:auto;font-family:Times New Roman;font-size:10pt;}\n" +
                ".p7{margin-left:0.25in;text-align:center;hyphenate:auto;font-family:Times New Roman;font-size:12pt;}\n" +
                ".p8{text-align:end;hyphenate:auto;font-family:Times New Roman;font-size:12pt;}\n" +
                ".p9{text-align:start;hyphenate:auto;font-family:Arial;font-size:9pt;}\n" +
                ".p10{text-align:center;hyphenate:auto;font-family:Arial;font-size:12pt;}\n" +
                ".td1{width:1.4652778in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td2{width:1.4645833in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td3{width:1.8243055in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td4{width:1.2416667in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td5{width:1.4597223in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td6{width:0.96319443in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td7{width:2.9430556in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td8{width:0.9777778in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td9{width:1.4326389in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td10{width:1.3888888in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td11{width:5.353472in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td12{width:3.0902777in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td13{width:4.609722in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td14{width:7.7in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td15{width:4.5909724in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td16{width:3.1090279in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td17{width:1.15in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td18{width:0.56319445in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td19{width:1.8111111in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td20{width:1.0666667in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td21{width:1.95in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td22{width:1.1590278in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".td23{width:6.540972in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
                ".r1{height:0.2125in;keep-together:always;}\n" +
                ".r2{height:1.075in;keep-together:always;}\n" +
                ".r3{height:0.24166666in;keep-together:always;}\n" +
                ".r4{height:2.3125in;keep-together:always;}\n" +
                ".r5{height:0.2875in;keep-together:always;}\n" +
                ".r6{height:0.065972224in;keep-together:always;}\n" +
                ".r7{height:0.5090278in;keep-together:always;}\n" +
                ".r8{height:0.18125in;keep-together:always;}\n" +
                ".r9{height:0.19166666in;keep-together:always;}\n" +
                ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body class=\"b1\">\n" +
                "<div class=\"d1\">\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">Purpose 目的:</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Through the Layered Process Audit to manufacturing related processes to verify the process meets the defined requirement, and issue corrective activities were implemented to make sure the process is under control.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>通过对制造相关过程的分层审核，确认过程控制符合规定的要求，问题改进措施在过程中得到落实，确保过程受控。 </span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">Scope 范围:</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>LPA is applicable to Incoming Quality Inspection, in-plant logistics management, Block and Head machining, ATPU, engine rework, finished engine warehousing storage and dispatch, </span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>LPA 适用于BFCEC进料检验、厂内物料管理、缸体缸盖加工过程、物料配送、ATPU过程、发动机返工过程以及成品发动机的存放和发运过程的分层审核的计划和实施</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">过程识别</span>\n" +
                "</p>\n" +
                "<table class=\"t1\">\n" +
                "<tbody>\n" +
                "<tr class=\"r1\">\n" +
                "<td class=\"td1\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process Input</span>\n" +
                "</p>\n" +
                "</td><td class=\"td2\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process Supplier</span>\n" +
                "</p>\n" +
                "</td><td class=\"td3\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process Output</span>\n" +
                "</p>\n" +
                "</td><td class=\"td4\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process Customer</span>\n" +
                "</p>\n" +
                "</td><td class=\"td5\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process KPI</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r2\">\n" +
                "<td class=\"td1\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Annual LPA Plan</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>LPA Checklist</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>Quality Information</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>年度分层审核计划</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>审核项目清单</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>质量信息</span>\n" +
                "</p>\n" +
                "</td><td class=\"td2\">\n" +
                "<p class=\"p2\">\n" +
                "<span class=\"s2\">LPA Auditor </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span class=\"s2\">LPA审核员 </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span class=\"s2\">QUA Engineer </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span class=\"s2\">质量工程师</span>\n" +
                "</p>\n" +
                "<p class=\"p2\"></p>\n" +
                "</td><td class=\"td3\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Closed LPA issues</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>关闭的审核不符合项</span>\n" +
                "</p>\n" +
                "</td><td class=\"td4\">\n" +
                "<p class=\"p2\">\n" +
                "<span class=\"s2\">LPA Related Departments(QUA, MFG，ME，MAT)</span>\n" +
                "</p>\n" +
                "</td><td class=\"td5\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Issue Closure Rate</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>问题关闭率</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<p class=\"p3\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">Responsibilities 职责</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">4.1 </span><span class=\"s3\">Quality Department (QUA) 质量部</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>QUA LPA Coordinator is responsible for LPA Planning, organizing and implementing, updating the issue list and the Monthly LPA checklist, verifying and confirming the status of the audit findings.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>质量部LPA协调员负责过程分层审核的策划、组织与实施，制定并更新LPA审核检查表和月度LPA审核清单，验证和确认审核问题状态。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">4.2 Manufacturing Department(MFG) 制造部</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>MFG LPA Coordinator is responsible for MFG daily LPA organizing and facilitating, Monthly summarizing and submitting LPA record and findings to QUA, organizing and facilitating the audit issue solving, and escalating to QUA when issue is unable to solve.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>MFG LPA协调员负责推动制造部日常LPA审核、分月总结，提交审核记录及审核发现的问题给质量部，组织并推进本部门审核问题的解决，无法解决的问题及时升级报质量部。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p4\">\n" +
                "<span class=\"s1\">4.3</span><span> </span><span class=\"s3\">Material Department (MAT) 材料部</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span>MAT LPA Coordinator is responsible for MAT daily LPA organizing and facilitating, Monthly summarizing and submitting LPA record and findings to QUA, organizing and facilitating the audit issue solving, and escalating to QUA when issue is unable to solve.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>MAT LPA协调员推动物料部日常LPA审核、分月总结，提交审核记录及审核发现的问题给质量部，组织并推进本部门审核问题的解决，无法解决的问题升级及时报质量部。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s3\">4.4 Other Departments问题的责任部门</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Department that has issue found through the audit shall take corrective actions or carry out the improvement, and deliver corrective reports as required.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>审核发现问题的责任部门负责实施问题的纠正和改进，并按照要求提供问题改进报告。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">Definitions定义:</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">5.1 LPA：Layered Process Audit.</span><span class=\"s4\"> </span><span>It is standardized evaluation process based on the audit and evaluation by every levels of people who will participate in evaluating and reviewing the production process by the predefined frequency to assure the manufacturing process is under control and strengthen the concept of Lean Production.  </span><span class=\"s4\">                                                     </span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">分层审核：</span><span class=\"s5\">由各级人员按照预先计划的频次定期参与评审并回顾整改为基础的标准化的评审过程，以确保制造过程受控并加强</span><a href=\"https://baike.baidu.com/item/%E7%B2%BE%E7%9B%8A%E5%88%B6%E9%80%A0/9024548%22 \\t %22_blank\"><span class=\"s5\">精益制造</span></a><span class=\"s5\">理念。</span>\n" +
                "</p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">5.2 LPA Auditors Competency LPA审核员能力要求</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Understanding of BFCEC engines structure and manufacture process.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>了解福田康明斯发动机结构和制造过程</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Understanding of applicable customer-specific requirements.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>了解适用的顾客特定要求。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Understanding requirements related to the scope of the audit.</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>了解与审核范围有关的要求。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Understand of how to plan，conduct，report，and close out audit findings</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>了解如何计划审核，实施审核，报告审核以及关闭审核发现。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>LPA Auditors shall be yearly internal certificated</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>LPA审核员需要做年度内部资格认证。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">5.3 LPA findings Classification Criteria  LPA审核问题评定原则：</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>See Table 1见表一</span><span class=\"s1\">。</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s3\">Procedure </span><span class=\"s6\">程序</span><span class=\"s3\">:</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>See Table 2见表二。</span>\n" +
                "</p>\n" +
                "<br>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Table 1表一</span>\n" +
                "</p>\n" +
                "<table class=\"t1\">\n" +
                "<tbody>\n" +
                "<tr class=\"r3\">\n" +
                "<td class=\"td6\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Definitions审核发现不符合程度</span>\n" +
                "</p>\n" +
                "</td><td class=\"td7\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Process Control </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>过程控制</span>\n" +
                "</p>\n" +
                "</td><td class=\"td8\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Frequency </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>频度</span>\n" +
                "</p>\n" +
                "</td><td class=\"td9\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Impact </span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>影响后果</span>\n" +
                "</p>\n" +
                "</td><td class=\"td10\">\n" +
                "<p class=\"p2\">\n" +
                "<span>Corrective/corrective action</span>\n" +
                "</p>\n" +
                "<p class=\"p2\">\n" +
                "<span>纠正/纠正措施</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r4\">\n" +
                "<td class=\"td6\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Major严重不符合项</span>\n" +
                "</p>\n" +
                "</td><td class=\"td7\">\n" +
                "<p class=\"p6\">\n" +
                "<span>The absence or total breakdown of a system to meet requirements. </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>系统性、区域性失效</span>\n" +
                "<br>\n" +
                "<span>例如：</span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>1）There is no process or method; there is no effective process for managing risk points. </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>没有流程或方法；无有效流程对风险点加以管控；</span>\n" +
                "<br>\n" +
                "<span>2）A process or methods that is not executed .</span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>有流程或方法，基本未执行；           </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>3) Any finding that would result in the probable shipment of nonconforming product ，and a condition that may result in the failure or materially reduce the usability of the products or services for their intended purpose。</span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>可能导致交运不合格品，任何可能导致产品或服务失效或预期的使用性能严重降低的不合格；                                                                                   </span>\n" +
                "</p>\n" +
                "</td><td class=\"td8\">\n" +
                "<p class=\"p6\">\n" +
                "<span class=\"s2\">3times</span><span class=\"s7\"> </span><span>non-conforming or above 3次或以上抽样不符合</span>\n" +
                "</p>\n" +
                "</td><td class=\"td9\">\n" +
                "<p class=\"p6\">\n" +
                "<span>poor process results and customer dissatisfaction. </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>导致过程结果差；</span>\n" +
                "<br>\n" +
                "<span>导致客户不满意；</span>\n" +
                "</p>\n" +
                "</td><td class=\"td10\">\n" +
                "<p class=\"p6\">\n" +
                "<span>corrective action </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>纠正措施</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r5\">\n" +
                "<td class=\"td6\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Minor一般不符合项</span>\n" +
                "</p>\n" +
                "</td><td class=\"td7\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Infrequent, individual or isolated lapse </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>偶然、个别、孤立的轻微问题；</span>\n" +
                "</p>\n" +
                "</td><td class=\"td8\">\n" +
                "<p class=\"p6\">\n" +
                "<span class=\"s2\">only 1-2 times</span><span class=\"s7\"> </span><span>non-conforming仅1、2次不符合；</span>\n" +
                "</p>\n" +
                "</td><td class=\"td9\">\n" +
                "<p class=\"p6\">\n" +
                "<span>No major impact to the process </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>不会对过程的最终有效性带来主要影响；</span>\n" +
                "</p>\n" +
                "</td><td class=\"td10\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Corrective </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>纠正</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r6\">\n" +
                "<td class=\"td6\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Observation观察项</span>\n" +
                "</p>\n" +
                "</td><td class=\"td11\" colspan=\"3\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Same as \"Minor non-conformance\", but the evidence is not sufficient, or beyond the scope of the audit</span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>同&ldquo;一般不符合项&rdquo;，但证据不是很充分，或超出审核范围</span>\n" +
                "</p>\n" +
                "</td><td class=\"td10\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Corrective </span>\n" +
                "</p>\n" +
                "<p class=\"p6\">\n" +
                "<span>纠正</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span>Table 2 表二</span>\n" +
                "</p>\n" +
                "<p class=\"p5\">\n" +
                "<img src=\"4aba.emf\" style=\"width:7.5425587in;height:6.883834in;vertical-align:text-bottom;\"></p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p7\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">7.0 Safety &amp; Environmental Information: 安全及环境信息：</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span>N/A 无</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.0 Associated Documents. 相关文件：</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<a href=\"tt.doc\"><span class=\"s8\">8.1 Reference Procedure/WI. 相关</span><span class=\"s8\">程序文件及作业指导书</span><span class=\"s8\">：</span></a>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s3\">8.1.1 </span><span class=\"s2\">CQI-8 Layered Process Audits Guideline《CQI-8 分层审核指南》</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.1.2 </span><span>FCP-07-01-01 Management Review Procedure《管理评审程序》</span>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.2   Reference Forms 引用表格</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.2.1</span><span> Annual Process Audit Plan《年度过程审核计划》</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.2.2</span><span> LPA Checklist《LPA检查表》</span>\n" +
                "</p>\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\">8.2.3 </span><span>Improvement and Tracking Form《问题整改及跟踪表》</span>\n" +
                "</p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<table class=\"t1\">\n" +
                "<tbody>\n" +
                "<tr class=\"r7\">\n" +
                "<td class=\"td12\" colspan=\"3\">\n" +
                "<p class=\"p5\">\n" +
                "<img src=\"0.png\" style=\"width:1.8988042in;height:0.42967224in;vertical-align:text-bottom;\"></p>\n" +
                "</td><td class=\"td13\" colspan=\"4\">\n" +
                "<p class=\"p8\">\n" +
                "<span class=\"s1\">Layered Process Audit Procedure</span>\n" +
                "</p>\n" +
                "<p class=\"p8\">\n" +
                "<span class=\"s3\">分层过程审核程序</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r8\">\n" +
                "<td class=\"td14\" colspan=\"7\">\n" +
                "<p class=\"p6\">\n" +
                "<span>■Procedure程序 </span><span class=\"s9\">□</span><span>Work Instruction 作业指导书</span><span class=\"s9\"> □ </span><span>Quality Plan 质量计划</span><span class=\"s9\"> □</span><span> Others 其它</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r8\">\n" +
                "<td class=\"td15\" colspan=\"5\">\n" +
                "<p class=\"p6\">\n" +
                "<span>QSI Document Control Number  QSI 文件控制编号</span>\n" +
                "</p>\n" +
                "</td><td class=\"td16\" colspan=\"2\">\n" +
                "<p class=\"p6\">\n" +
                "<span>                                                          FCP-07-01-05</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r8\">\n" +
                "<td class=\"td17\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Revision 版本</span>\n" +
                "</p>\n" +
                "</td><td class=\"td18\">\n" +
                "<p class=\"p6\">\n" +
                "<span>       04</span>\n" +
                "</p>\n" +
                "</td><td class=\"td19\" colspan=\"2\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Original Date撰写日期</span>\n" +
                "</p>\n" +
                "</td><td class=\"td20\">\n" +
                "<p class=\"p6\">\n" +
                "<span>      2009-02-28</span>\n" +
                "</p>\n" +
                "</td><td class=\"td21\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Revised Date修订日期</span>\n" +
                "</p>\n" +
                "</td><td class=\"td22\">\n" +
                "<p class=\"p6\">\n" +
                "<span>    2019-04-03</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"r9\">\n" +
                "<td class=\"td23\" colspan=\"6\">\n" +
                "<p class=\"p6\">\n" +
                "<span>Classification分类: </span><span class=\"s9\">□</span><span> Confidential机密</span><span class=\"s10\"> </span><span>■ Internal Use内部使用 </span><span class=\"s9\">□</span><span> Public Use公开使用</span>\n" +
                "</p>\n" +
                "</td><td class=\"td22\">\n" +
                "<p class=\"p9\">\n" +
                "<span>Page 1 of 5</span>\n" +
                "</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p9\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p10\">\n" +
                "<span class=\"s11\">Uncontrolled Document 非受控文件</span>\n" +
                "</p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p9\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p5\"></p>\n" +
                "<p class=\"p1\"></p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n"));
    }
}
