package com.xiaohansong.codemaker;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.components.ApplicationComponent;

/**
 * @author hansong.xhs
 * @version \$Id: com.xiaohansong.codemaker.CodeMaker.java, v 0.1 2017-01-19 下午10:18 hansong.xhs Exp $$
 */
public class CodeMaker implements ApplicationComponent {
    public CodeMaker() {
    }

    @Override
    public void initComponent() {
    }

    @Override
    public void disposeComponent() {
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "com.xiaohansong.codemaker.CodeMaker";
    }
}
