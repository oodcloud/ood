package cn.generator.pojo;

/**
 * Created by vog1g on 2017/5/13.
 */
public class MovieWithMovieClass extends MovieWithBLOBs {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_class.c_id
     *
     * @mbggenerated
     */
    private Short cId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_class.c_name
     *
     * @mbggenerated
     */
    private String cName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_class.c_pid
     *
     * @mbggenerated
     */
    private Short cPid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_class.c_sort
     *
     * @mbggenerated
     */
    private Short cSort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie.addtime
     *
     * @mbggenerated
     */
    private String addtime;

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_class.c_hide
     *
     * @mbggenerated
     */
    private Boolean cHide;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_class.c_id
     *
     * @return the value of movie_class.c_id
     *
     * @mbggenerated
     */
    public Short getcId() {
        return cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_class.c_id
     *
     * @param cId the value for movie_class.c_id
     *
     * @mbggenerated
     */
    public void setcId(Short cId) {
        this.cId = cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_class.c_name
     *
     * @return the value of movie_class.c_name
     *
     * @mbggenerated
     */
    public String getcName() {
        return cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_class.c_name
     *
     * @param cName the value for movie_class.c_name
     *
     * @mbggenerated
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_class.c_pid
     *
     * @return the value of movie_class.c_pid
     *
     * @mbggenerated
     */
    public Short getcPid() {
        return cPid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_class.c_pid
     *
     * @param cPid the value for movie_class.c_pid
     *
     * @mbggenerated
     */
    public void setcPid(Short cPid) {
        this.cPid = cPid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_class.c_sort
     *
     * @return the value of movie_class.c_sort
     *
     * @mbggenerated
     */
    public Short getcSort() {
        return cSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_class.c_sort
     *
     * @param cSort the value for movie_class.c_sort
     *
     * @mbggenerated
     */
    public void setcSort(Short cSort) {
        this.cSort = cSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_class.c_hide
     *
     * @return the value of movie_class.c_hide
     *
     * @mbggenerated
     */
    public Boolean getcHide() {
        return cHide;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_class.c_hide
     *
     * @param cHide the value for movie_class.c_hide
     *
     * @mbggenerated
     */
    public void setcHide(Boolean cHide) {
        this.cHide = cHide;
    }
}
