package org.cft_latest.repository.argumentRepo;

public enum ArgsEnum {
    o,
    p,
    a,
    s,
    f,
    fp;

    public static String getName(ArgsEnum arg) {
        return "-"+arg.name();
    }
}
