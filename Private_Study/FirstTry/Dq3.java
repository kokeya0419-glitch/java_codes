package Private_Study.FirstTry;
public class Dq3 {
    public static void main(String[] args){
        
        addMember addM = new addMember();
        RandomMonster rdmmns = new RandomMonster();
        War war = new War();

        Job hero = addM.joinMember();
        Monster monster = rdmmns.appearance();

        war.startFight(hero, monster);

    }
}