package com.xiaohansong.codemaker.ui;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.uiDesigner.core.GridConstraints;
import com.xiaohansong.codemaker.CodeMakerSettings;
import com.xiaohansong.codemaker.CodeTemplate;
import com.xiaohansong.codemaker.util.CodeMakerUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author hansong.xhs
 * @version $Id: TemplateEditPane.java, v 0.1 2017-01-31
 */
public class TemplateEditPane {

    private JPanel     templateEdit;
    private JTextField templateNameText;
    private JTextField classNumberText;
    private JTextField classNameText;
    private JButton    deleteTemplateButton;
    private JPanel     editorPane;
    private JTextField sourcePathText;
    private JTextField fileNameText;
    private JTextField suffixText;
    private Editor     editor;

    public TemplateEditPane(CodeMakerSettings settings, String template,
                            CodeMakerConfiguration parentPane) {
        CodeTemplate codeTemplate = settings.getCodeTemplate(template);
        if (codeTemplate == null) {
            codeTemplate = CodeTemplate.EMPTY_TEMPLATE;
        }

        templateNameText.setText(codeTemplate.getName());
        classNumberText.setText(String.valueOf(codeTemplate.getClassNumber()));
        classNameText.setText(codeTemplate.getClassNameVm());
        sourcePathText.setText(codeTemplate.getSourcePath());
        fileNameText.setText(codeTemplate.getFileName());
        suffixText.setText(codeTemplate.getSuffix());

        addVmEditor(codeTemplate.getCodeTemplate());
        deleteTemplateButton.addActionListener(e -> {
            int result = Messages.showYesNoDialog("Delete this template?", "Delete", null);
            if (result == Messages.OK) {
                settings.removeCodeTemplate(template);
                parentPane.refresh(settings);
            }
        });
    }

    private void addVmEditor(String template) {
        EditorFactory factory = EditorFactory.getInstance();
        Document velocityTemplate = factory.createDocument(template);
        editor = factory.createEditor(velocityTemplate, null, FileTypeManager.getInstance()
            .getFileTypeByExtension("vm"), false);
        GridConstraints constraints = new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, 300), null, 0, true);
        editorPane.add(editor.getComponent(), constraints);
    }

    /**
     * Getter method for property <tt>templateEdit</tt>.
     *
     * @return property value of templateEdit
     */
    public JPanel getTemplateEdit() {
        return templateEdit;
    }

    public String getClassName() {
        return classNameText.getText();
    }

    public String getTemplateName() {
        return templateNameText.getText();
    }

    public String getTemplate() {
        return editor.getDocument().getText();
    }

    public String getSourcePath (){
        return  sourcePathText.getText();
    }

    public String getFileName(){
        return  fileNameText.getText();
    }

    public String getSuffix(){
        return suffixText.getText();
    }

    /**
     *
     * @return -1 if classNumberText is not number
     */
    public int getClassNumber() {
        if (CodeMakerUtil.isNumeric(classNumberText.getText())) {
            return Integer.parseInt(classNumberText.getText());
        }
        return -1;
    }
}
