package Blocks;

import Render.RGBColor;

public class Head extends Blocks{
    private String startCommand;

    public Head(String head) {
        super(head);
    }

    // Render head
    @Override
    public String render(String content) {
        String renderedHead;
        switch (content.lastIndexOf('#'))
        {
            case 0:
                formatStartCommand(style.getH1Sign(), style.getH1Color());
                renderedHead = formatHead(content);
                break;
            case 1:
                formatStartCommand(style.getH2Sign(), style.getH2Color());
                renderedHead = formatHead(content);
                break;
            case 2:
                formatStartCommand(style.getH3Sign(), style.getH3Color());
                renderedHead = formatHead(content);
                break;
            case 3:
                formatStartCommand(style.getH4Sign(), style.getH4Color());
                renderedHead = formatHead(content);
                break;
            case 4:
                formatStartCommand(style.getH5Sign(), style.getH5Color());
                renderedHead = formatHead(content);
                break;
            case 5:
                formatStartCommand(style.getH6Sign(), style.getH6Color());
                renderedHead = formatHead(content);
                break;
            default:
                renderedHead = "";
        }
        return renderedHead;
    }

    private void formatStartCommand(String headSign, RGBColor headColor) {
        String COMMAND_START_FORMAT = "\33[38;2;%d;%d;%dm%s ";
        startCommand = String.format(COMMAND_START_FORMAT,
                headColor.getR(),
                headColor.getG(),
                headColor.getB(),
                headSign);
    }

    private String formatHead(String content) {
        String END_COMMAND = "\33[0m";
        return startCommand + content.replace("#","") + END_COMMAND;
    }
}
