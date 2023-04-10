import java.util.ArrayList;

class NewsPublisher{
    private String news;
    private String time;
    ArrayList <NewsAgency> lm= new ArrayList<NewsAgency>();

    public void setNews(String news) {
        this.news = news;
    }
    public String getNews() {
        return news;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
        notifyAgency();
    }

    public void  addAgency(NewsAgency n){
        lm.add(n);
        System.out.println("The News Agency :" + n + " Added Successfully");
    }
    public void removeAgency(NewsAgency n){
        lm.remove(n);
    }

    public void notifyAgency(){
        for(NewsAgency na:lm){
            na.agencyWork();
        }
    }

}

abstract  class NewsAgency{
    NewsPublisher np;
    public abstract void agencyWork();
}

class MorningNewsAgency extends NewsAgency{
    MorningNewsAgency(NewsPublisher nep){
        np=nep;
        np.addAgency(this);
    }
    @Override
    public void agencyWork() {
        System.out.println("This is morning news Bulletin with news :"+ np.getNews());
        System.out.println("THe current time is: "+np.getTime());
    }
}


class EveningNewsAgency extends NewsAgency{
   EveningNewsAgency(NewsPublisher nep){
        np=nep;
         np.addAgency(this);
    }
    @Override
    public void agencyWork(){
        System.out.println("This is evening news Bulletin with news :"+ np.getNews());
        System.out.println("THe current time is: "+np.getTime());
    }
}

class NewsTest{
    public static void main(String[] args) {
        NewsPublisher np= new NewsPublisher();

        NewsAgency n1= new MorningNewsAgency(np);

        NewsAgency n2= new EveningNewsAgency(np);

        np.setNews("Hello this is the New Breaking News ");

        np.setTime("Morning");

    }
}