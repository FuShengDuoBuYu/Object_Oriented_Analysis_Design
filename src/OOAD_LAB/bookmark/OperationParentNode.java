package OOAD_LAB.bookmark;

public class OperationParentNode {
    private Integer level;
    private String title;
    private Integer index;

    public Integer getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OperationParentNode(Integer level, String title) {
        this.level = level;
        this.title = title;
    }

    public OperationParentNode(Integer level, String title, Integer index) {
        this.level = level;
        this.title = title;
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
