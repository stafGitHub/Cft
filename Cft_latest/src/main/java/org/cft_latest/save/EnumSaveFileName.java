package org.cft_latest.save;

public enum EnumSaveFileName {
    strings,integers,floats;

    public static String getFileName(EnumSaveFileName enumSaveFileName) {
        return enumSaveFileName.toString() + ".txt";
    }
}
