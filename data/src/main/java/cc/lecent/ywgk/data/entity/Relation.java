package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 关系
 * </pre>
 */
public class Relation {
    private String relationCode;
    private String relationName;

    public String getRelationCode() {
        return relationCode;
    }

    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relationCode='" + relationCode + '\'' +
                ", relationName='" + relationName + '\'' +
                '}';
    }
}
