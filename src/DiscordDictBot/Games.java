package DiscordDictBot;

import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Games {
Dictionary newDict = new Dictionary();


public ArrayList<String> fillInTheBlank(Dictionary temp_1, GuildMessageReceivedEvent event) {

	ArrayList<Word> dic_temp = temp_1.getList();
	ArrayList<Word> dic = new ArrayList<Word>();

	for(int i = 0; i < dic_temp.size(); i ++) {
		dic.add(dic_temp.get(i));
	}

	EmbedBuilder commandsMenu = new EmbedBuilder();
	commandsMenu.setColor(0x66d8ff);

	String options = "";

	for(int i = 0; i < dic.size(); i++) {
		options += dic.get(i).getWord() + ", ";

	}
	ArrayList<String> answer = new ArrayList<String>();

	String choices = "";
	int count = dic.size();
	for(int i = 0; i < count; i++) {
		Word temp = dic.remove((int)(Math.random() * (count - i)));
		answer.add(temp.getWord());
		int temp2 = i+1;
		choices += temp2 + ". " + temp.getSentence().replace(temp.getWord(), "__________") + "\n";
	}

	choices += "\nThe options: " + options + "\n";
	commandsMenu.setDescription(choices);
	event.getChannel().sendMessage(commandsMenu.build()).queue();

	return answer;

	} 


	public ArrayList<String> matching(Dictionary temp_1, GuildMessageReceivedEvent event) {
        EmbedBuilder commandsMenu = new EmbedBuilder();
        commandsMenu.setColor(0x66d8ff);

        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<Word> dic = temp_1.getList();

        ArrayList<String> def = new ArrayList<String>();
        ArrayList<String> word = new ArrayList<String>();

        for(int i = 0; i < dic.size(); i++) {
            def.add(dic.get(i).getDef());
            word.add(dic.get(i).getWord());

        }
        String question = "";
        String options = "Options: ";
        int count = dic.size();
        System.out.println(count);
        for(int i = 0; i < count; i++) {
            String temp_def = def.remove((int)(Math.random() * (count - i)));
            String temp_word = word.remove((int)(Math.random() * (count - i)));
            Word t = temp_1.getWord(temp_word);
            answer.add(temp_1.getWordFromDef(temp_def));
            question += (i+1) + ". " + temp_def + "\n"; 
            options += temp_word + ", ";

        }


        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        question += "\n" + options;
        commandsMenu.setDescription(question);
        event.getChannel().sendMessage(commandsMenu.build()).queue();


        return answer;
    }


}
