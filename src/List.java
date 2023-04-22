import java.util.ArrayList;
public class List {
    
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> vikas = new ArrayList<>();

        ArrayList<String> games = new ArrayList<String>();
        games.add("GTA 5");
        games.add("minecraft");
        games.add("frostpunk");
        games.add("batman origins");

        ArrayList<String> songs = new ArrayList<String>();
        songs.add("nandemonaiya");
        songs.add("daijobu");
        songs.add("contradiction");

        ArrayList<String> subject = new ArrayList<String>();
        subject.add("FOCP-II");
        subject.add("english");

        ArrayList<Integer> cost = new ArrayList<Integer>();
        cost.add(21);
        cost.add(45);
        cost.add(12+45);
        cost.add(7*7);

        vikas.add(games);
        vikas.add(songs);
        vikas.add(subject);
        show(subject);

    }

    static void show(ArrayList<String> str){
        for(String i: str){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}