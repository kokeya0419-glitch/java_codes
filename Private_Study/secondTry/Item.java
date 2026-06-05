package Private_Study.secondTry;

public class Item {
    private String name;
    private int itemHp;
    private int itemMp;
    private int itemPower;
    private int itemDefend;
    private int itemSpeed;
    private int itemIntelligence;
    private int itemBuyPrice;
    private int itemSellPrice;

    public void setItemName(String name){
        this.name = name;
    }
    public String getItemName(){
        return this.name;
    }

    public void setItemHp(int hp){
        this.itemHp = hp;
    }
    public int getItemHp(){
        return this.itemHp;
    }

    public void setItemMp(int mp){
        this.itemMp = mp;
    }
    public int getItemMp(){
        return this.itemMp;
    }

    public void setItemPower(int power){
        this.itemPower = power;
    }
    public int getItemPower(){
        return this.itemPower;
    }

    public void setItemDefend(int defend){
        this.itemDefend = defend;
    }
    public int getItemDefend(){
        return this.itemDefend;
    }

    public void setItemSpeed(int speed){
        this.itemSpeed = speed;
    }
    public int getItemSpeed(){
        return this.itemSpeed;
    }

    public void setItemIntelligence(int intelligence){
        this.itemIntelligence = intelligence;
    }
    public int getItemintelligence(){
        return this.itemIntelligence;
    }

    public void setItemBuyPrice(int buyPrice){
        this.itemDefend = buyPrice;
    }
    public int getItemBuyPrice(){
        return this.itemBuyPrice;
    }

    public void setItemSellPrice(int sellPrice){
        this.itemSellPrice = sellPrice;
    }
    public int getItemSellPrice(){
        return this.itemSellPrice;
    }
}
