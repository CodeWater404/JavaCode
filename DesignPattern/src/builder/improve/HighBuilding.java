package builder.improve;

/**
 * @author ： CodeWater
 * @create ：2022-05-08-15:10
 * @Function Description ：
 */
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
// TODO Auto-generated method stub
        System.out.println(" 高楼的打地基 100 米 ");
    }

    @Override
    public void buildWalls() {
// TODO Auto-generated method stub
        System.out.println(" 高楼的砌墙 20cm ");
    }

    @Override
    public void roofed() {
// TODO Auto-generated method stub
        System.out.println(" 高楼的透明屋顶 ");
    }
}
