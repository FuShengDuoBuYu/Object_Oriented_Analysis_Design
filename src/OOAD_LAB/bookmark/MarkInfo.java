package OOAD_LAB.bookmark;

import java.util.Objects;

public class MarkInfo {
    private String name;
    private String url;
    private Integer readCount;
    private Boolean isRead;
    private Integer level;
    public MarkInfo(String name, String url, Integer readCount, Boolean isRead, Integer level) {
        this.name = name;
        this.url = url;
        this.readCount = readCount;
        this.isRead = isRead;
        this.level = level;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public String getName() {
        return name;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public String getUrl() {
        return url;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkInfo markInfo = (MarkInfo) o;
        System.out.println("markInfo.name = " + markInfo.name);
        System.out.println("markInfo.url = " + markInfo.url);
        System.out.println("markInfo.readCount = " + markInfo.readCount);
        System.out.println("markInfo.isRead = " + markInfo.isRead);
        System.out.println("markInfo.level = " + markInfo.level);
        System.out.println("this.name = " + this.name);
        System.out.println("this.url = " + this.url);
        System.out.println("this.readCount = " + this.readCount);
        System.out.println("this.isRead = " + this.isRead);
        System.out.println("this.level = " + this.level);

        return Objects.equals(name, markInfo.name) && Objects.equals(url, markInfo.url) && Objects.equals(readCount, markInfo.readCount) && Objects.equals(isRead, markInfo.isRead) && Objects.equals(level, markInfo.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, readCount, isRead, level);
    }
}
