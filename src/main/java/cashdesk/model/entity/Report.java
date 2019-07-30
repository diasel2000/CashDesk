package cashdesk.model.entity;

import java.util.Objects;

public class Report {
    private int id;
    private Character type;
    private String content;

    public Report(int id, Character type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Report() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id &&
                Objects.equals(type, report.type) &&
                Objects.equals(content, report.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, content);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
