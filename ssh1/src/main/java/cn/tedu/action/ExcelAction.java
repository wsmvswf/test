package cn.tedu.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelAction {
	private InputStream excel;
	
	public InputStream getExcel() {
		return excel;
	}
	public void setExcel(InputStream excel) {
		this.excel = excel;
	}
	
	public String execute(){
		try {
			byte[] data = createExcel();
			excel=new ByteArrayInputStream(data);
			return "exl";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public byte[] createExcel() throws IOException{
		// Apache poi
		// 工作簿   >工作表>行>格子
		//workbook> sheet>row>cell
		
		//创建工作簿
		HSSFWorkbook workbook=
				new HSSFWorkbook();
		//在工作簿中创建工作表
		HSSFSheet sheet = 
				workbook.createSheet("演示");
		//工作表里创建数据行
		HSSFRow row = sheet.createRow(0);
		//在行中创建格子
		HSSFCell c1 = row.createCell(0);
		//在格子中添加内容
		c1.setCellValue("编号");
		row.createCell(1).setCellValue("内容");
		//再添加一行
		row = sheet.createRow(1);
		row.createCell(0).setCellValue("1");
		row.createCell(1)
			.setCellValue("Hello World!");
		//将excel对象转换为数据
		ByteArrayOutputStream out=
			new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		byte[] data = out.toByteArray();
		return data;
	}
}









