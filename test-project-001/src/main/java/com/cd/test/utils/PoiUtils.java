package com.cd.test.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * POI Util Class
 */
public class PoiUtils {

    /**
     *
     * @param cell
     * @return
     */
    public static String cellValue(Cell cell) {
        String value;
        Object object;
        switch (CellType.forInt(cell.getCellType())) {
            case STRING:
                object = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    object = Constants.SIMPLE_DATE_FORMAT.format(cell.getDateCellValue());
                } else {
                    object = cell.getNumericCellValue();
                }
                break;
            case BOOLEAN:
                object = cell.getBooleanCellValue();
                break;
            case FORMULA:
                object = cell.getCellFormula();
                break;
            case BLANK:
                object = null;
                break;
            default:
                object = null;
        }
        value = String.valueOf(object);
        return StringUtil.dealEmptyStr(value);
    }
}
    