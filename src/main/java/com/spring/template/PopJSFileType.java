package com.spring.template;

public enum PopJSFileType {
    Pop("Pop", "PopFileTemplate"),
    PopModel("Model", "PopModelFileTemplate"),
    PopController("Controller", "PopControllerFileTemplate");

    private final String fileType;
    private final String impletationClassName;

    private PopJSFileType(String fileType, String impletationClassName) {
        this.fileType = fileType;
        this.impletationClassName = impletationClassName;
    }

    public String getFileType() {
        return fileType;
    }
    public String getImpletationClassName() {
        return impletationClassName;
    }
}
