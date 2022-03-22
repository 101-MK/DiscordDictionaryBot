package DiscordDictBot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Word {
	String wordName;


	String definition;
	String sentence;
	String defUrl;
	String sent_url;
	Document doc;


	public Word(String input) {
		wordName = input;
		definition = "";
		sentence = "";
		defUrl = "https://www.dictionary.com/browse/";
		sent_url = "https://sentence.yourdictionary.com/";

		try{
		doc = Jsoup.connect(defUrl +""+ wordName).get();
		Document doc2 = Jsoup.connect(sent_url + wordName).get();

		Element def = doc.select("span.one-click-content").first();
		Element sent = doc2.select("span.sentence-item__text").first();

		definition = "The definition is: " + def.text();
		sentence = sent.text().toLowerCase();
		String title = doc.title();
		System.out.println(definition);
		System.out.println(sentence);
	  }
		catch (Exception e){
			System.out.println("not a valid word");
		}

	}

	public String getDef() {
		return definition;
	}

	public String getWord() {
		return wordName;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getDefUrl() {
		return defUrl;
	}

	public void setDefUrl(String defUrl) {
		this.defUrl = defUrl;
	}

	public String getSent_url() {
		return sent_url;
	}

	public void setSent_url(String sent_url) {
		this.sent_url = sent_url;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public static void main(String[] args) throws IOException {
		Word ws = new Word("43423423432");
	}

}
