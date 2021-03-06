package com.xiaohansong.codemaker;

import com.intellij.openapi.util.text.StringUtil;

/**
 * @author hansong.xhs
 * @version $Id: CodeTemplate.java, v 0.1 2017-01-28
 */
public class CodeTemplate {

    /**
     * template name
     */
    private String name;

    /**
     * the generated class name, support velocity
     */
    private String classNameVm;

    /**
     * code template in velocity
     */
    private String codeTemplate;

    /**
     * the number of template context class
     */
    private int    classNumber;

    private String sourcePath;

    private String fileName;

    private String suffix;


    public CodeTemplate() {
    }

    public CodeTemplate(String name, String classNameVm, String codeTemplate, int classNumber,String sourcePath,String fileName,String suffix) {
        this.name = name;
        this.classNameVm = classNameVm;
        this.codeTemplate = codeTemplate;
        this.classNumber = classNumber;
        this.sourcePath = sourcePath;
        this.fileName = fileName;
        this.suffix = suffix;
    }

    public boolean isValid() {
        return StringUtil.isNotEmpty(getClassNameVm()) && StringUtil.isNotEmpty(getName())
               && StringUtil.isNotEmpty(getCodeTemplate()) && classNumber != -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CodeTemplate that = (CodeTemplate) o;

        if (classNumber != that.classNumber)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (classNameVm != null ? !classNameVm.equals(that.classNameVm) : that.classNameVm != null)
            return false;
        if(sourcePath != null ? !sourcePath.equals(that.sourcePath) : that.sourcePath != null )
            return false;
        if(fileName != null ? !fileName.equals(that.fileName) : that.fileName != null)
            return false;
        if(suffix != null ? !suffix.equals(that.suffix) : that.suffix != null)
            return false;

        return codeTemplate != null ? codeTemplate.equals(that.codeTemplate)
            : that.codeTemplate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (classNameVm != null ? classNameVm.hashCode() : 0);
        result = 31 * result + (codeTemplate != null ? codeTemplate.hashCode() : 0);
        result = 31 * result + (sourcePath != null ? sourcePath.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode():0);
        result = 31 * result + (suffix != null ? suffix.hashCode(): 0);
        result = 31 * result + classNumber;
        return result;
    }

    public static final CodeTemplate EMPTY_TEMPLATE = new CodeTemplate("", "", "", 1,"","","");

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>codeTemplate</tt>.
     *
     * @return property value of codeTemplate
     */
    public String getCodeTemplate() {
        return codeTemplate;
    }

    /**
     * Setter method for property <tt>codeTemplate</tt>.
     *
     * @param codeTemplate value to be assigned to property codeTemplate
     */
    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    /**
     * Getter method for property <tt>classNumber</tt>.
     *
     * @return property value of classNumber
     */
    public int getClassNumber() {
        return classNumber;
    }

    /**
     * Setter method for property <tt>classNumber</tt>.
     *
     * @param classNumber value to be assigned to property classNumber
     */
    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    /**
     * Getter method for property <tt>classNameVm</tt>.
     *
     * @return property value of classNameVm
     */
    public String getClassNameVm() {
        return classNameVm;
    }

    /**
     * Setter method for property <tt>classNameVm</tt>.
     *
     * @param classNameVm value to be assigned to property classNameVm
     */
    public void setClassNameVm(String classNameVm) {
        this.classNameVm = classNameVm;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
