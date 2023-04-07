import java.util.ArrayList;
import java.util.List;

//ORIGINATOR CLASS
class ArticleObjectFormatter {
    private String font;
    private int fontsize;

    private String content;

    public ArticleObjectFormatter(String font, int fontsize, String content) {
        this.font = font;
        this.content = content;
        this.fontsize = fontsize;
    }


    //GETTER AND SETTERS FOR THE OBJECT INSTANCES
    public int getFontsize() {
        return fontsize;
    }

    public String getContent() {
        return content;
    }

    public String getFont() {
        return font;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    public MementoArticleObject saveTheArticleState() {
        return new MementoArticleObject(this.font, this.content, this.fontsize);
    }

    public void restoreArticle(MementoArticleObject m1) {
        this.fontsize = m1.getFontsize();
        this.font = m1.getFont();
        this.content = m1.getContent();
    }

    public void Article() {
        System.out.println("THe Article has font size : " + this.getFontsize() +
                "\nFont is: " + this.getFont() +
                "\nContent is:" + this.getContent());
    }

    @Override
    public String toString() {
        return "THe Article has font size : " + this.getFontsize() +
                "\nFont is: " + this.getFont() +
                "\nContent is:" + this.getContent();
    }
}

class MementoArticleObject {
    private int fontsize;
    private String content;
    private String font;

    public MementoArticleObject(String font, String content, int fontsize) {
        this.content = content;
        this.fontsize = fontsize;
        this.font = font;
    }

    public String getFont() {
        return font;
    }

    public int getFontsize() {
        return fontsize;
    }

    public String getContent() {
        return content;
    }
}

class CareTakerArticle{
    private List<MementoArticleObject> list= new ArrayList<MementoArticleObject>();

    public void add(MementoArticleObject m1){
        list.add(m1);
    }

    public MementoArticleObject get(int i){
       return list.get(i);
    }

}

class ArticleTesting {
    public static void main(String[] args) {
        ArticleObjectFormatter a1 = new ArticleObjectFormatter("Times new Roman", 12, "hello");
        a1.Article();

        //SAVING THE CONTENT
        a1.saveTheArticleState();

        //ADDING TO LIST
        CareTakerArticle c1= new CareTakerArticle();
        c1.add(a1.saveTheArticleState());

        a1.setContent("new hello");
        a1.setFont("Algerian");
        a1.setFontsize(22);

        System.out.println();
        System.out.println("Retriving the Initial Stored Article:\n"+c1.get(0).getContent()+"\n"+
                c1.get(0).getFont()+"\n"+
                c1.get(0).getFontsize());


    }
}