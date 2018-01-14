package pubenum;

/**
 * Created by hldev on 18-1-14.
 */
public enum RecordNum {
    LARGER("LARGER",100);

    private String name;
    private int value;

    RecordNum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
