package com.aniketshaw29.exportToExcel.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateExcel {

    private List <Boat> targetList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;


    public GenerateExcel(List <Boat> targetList) {
        this.targetList = targetList;
        workbook = new XSSFWorkbook();
    }

    private String[] getExcelColumns() {
    	String[] excelcolumns = {
    			"id",
    			"name",
    		    "model",
    		    "yearBuilt",
    		    "lengthInFeet",
    	};    	
    	return excelcolumns;
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Aniket Shaw's");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        //creating columns in sheet
        String[] excelcolumns = getExcelColumns();
        for(int i=0; i<excelcolumns.length; i++)
        	createCell(row, i, excelcolumns[i], style); 
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);  

        if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Float) {
            cell.setCellValue((Float) valueOfCell);
        } else if (valueOfCell instanceof Double) {
            cell.setCellValue((Double) valueOfCell);
        } else if(valueOfCell instanceof Boolean){
            cell.setCellValue((Boolean) valueOfCell);
        }

        cell.setCellStyle(style);
    }

    private CellStyle createDefaultCellStyle(){
    	CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        return style;
    }

    private void write() {
        int rowCount = 1;
        CellStyle style = createDefaultCellStyle();

        for (Boat record: targetList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getName(), style);
            createCell(row, columnCount++, record.getModel(), style);
            createCell(row, columnCount++, record.getYearBuilt(), style);
            createCell(row, columnCount++, record.getLengthInFeet(), style);
        }
    }

    public ByteArrayInputStream exportToExcel() throws IOException {     
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
        	writeHeader();
            write();
            workbook.write(out);
            workbook.close();   
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}