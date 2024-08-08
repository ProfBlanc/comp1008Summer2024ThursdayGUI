package ca.georgiancollege.comp1008summer2024thursdaygui;

import java.nio.file.Files;
import java.nio.file.Path;

public class LoginModel {
    //responsible for login page process
        //REGISTER
    //LOGIN

    private String username, password;
    private Path rootPath = Path.of("src/main/resources/credentials");

    public LoginModel(){
        try{
            if(!Files.exists(rootPath)){
                Files.createDirectory(rootPath);
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() < 5)
            throw new IllegalArgumentException("Password too short");
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.length() < 5)
            throw new IllegalArgumentException("Username is too  short");
        this.username = username;
    }
    public boolean processLoginRequest(String username, String password)
            throws Exception {

        //get a list of all the file names
        String[] fileNames = rootPath.toFile().list();
        //iterate throw them and determine if username+.txt is found in the list of string file names
        for(String file : fileNames){
            if(file.equals(username + ".txt")){
                //if yes, open that file and determine if password == file content
                if(password.equals(Files.readString(rootPath.resolve(username+".txt")))){
                    return true;
                }
                break;
            }
        }
        //if no, throw error: sent to the view
        throw new IllegalArgumentException("Incorrect username and/or password");

    }
    public void processRegisterRequest(String username, String password)
    throws Exception{
        setUsername(username);
        setPassword(password);

        addCredentialsToFile(username, password);
    }
    private void addCredentialsToFile(String username, String password)
    throws Exception{
            Files.writeString(rootPath.resolve(username + ".txt"), password);
    }
}
