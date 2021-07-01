package com.practice.state;

public class Canvas {

    private Tool currentTool;
    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public void draw(){
        currentTool.draw();
    }
}
