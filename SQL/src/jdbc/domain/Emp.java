package jdbc.domain;

import java.util.Date;
/**
 * @author ： CodeWater
 * @create ：2022-03-09-11:03
 * @Function Description ：封装Emp表数据的JavaBean
 */
public class Emp {
    private int id;
    private String ename;
    private int job_id;
    private int mgr;
    private Date joindate;
    private double salary;
    //奖金
    private double bonus;
    private int dept_id;
    
    public int getId(){
        return id;
    }
    
    public void setId( int id ){
        this.id = id;
    }
    
    public String getEname(){
        return ename ;
    }
    
    public void setEname( String name ){
        this.ename = name ;
    }
    
    public int getJob_id(){
        return job_id;
    }
    
    public void setJob_id( int job_id ){
        this.job_id = job_id;
    }
    
    public int getMgr(){
        return mgr;
    }
    
    public void setMgr( int mgr ){
        this.mgr = mgr ;
    }
    
    public Date getJoindate( ){
        return joindate;
    }
    
    public void setJoindate( Date joindate ){
        this.joindate = joindate;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void setSalary( double salary ){
        this.salary = salary;
    }
    
    public double getBonus(){
        return bonus;
    }
    
    public void setBonus( double bonus ){
        this.bonus = bonus;
    }
    
    public int getDept_id(){
        return dept_id;
    }
    
    public void setDept_id( int dept_id ){
        this.dept_id = dept_id;
    }
    
    @Override
    public String toString(){
        return "Emp{" +
                "id=" + id + 
                ",ename=" + ename +
                ",job_id=" + job_id +
                ",mgr=" + mgr +
                ",joindate=" + joindate +
                ",salary=" + salary +
                ",bonus=" + bonus + 
                ",dept_id=" + dept_id +
                "}";
    }
}
