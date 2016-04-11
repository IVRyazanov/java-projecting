package observerThread;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class MboObject {
    @Override
    public String toString() {
        return "MboObject{" +
                "siteid='" + siteid + '\'' +
                ", mboNum='" + mboNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MboObject mboObject = (MboObject) o;

        if (mboNum != null ? !mboNum.equals(mboObject.mboNum) : mboObject.mboNum != null) return false;
        if (siteid != null ? !siteid.equals(mboObject.siteid) : mboObject.siteid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mboNum != null ? mboNum.hashCode() : 0;
        result = 31 * result + (siteid != null ? siteid.hashCode() : 0);
        return result;
    }

    public MboObject(String mboNum, String siteid) {
        this.mboNum = mboNum;
        this.siteid = siteid;
    }

    private String mboNum;
    private String siteid;

    public String getSiteid() {
        return siteid;
    }

    public String getMboNum() {
        return mboNum;
    }

}
