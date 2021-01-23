import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    @FXML private TextField newTask;
    @FXML private ListView<String> taskList;
    private String filepath="data.txt";
    private File data=new File(filepath);

    public void addNewTask(ActionEvent e){
        String text=newTask.getText();

        if(!text.equals("")){
            taskList.getItems().add(text);
            newTask.setText("");
        }else{
            System.out.println("No Input ...");
        }
    }

    public void deleteTask(ActionEvent e){
        String selected =taskList.getSelectionModel().getSelectedItem();
        if(selected != null){
            taskList.getItems().remove(selected);
        }else{
            System.out.println("No task selected ...");
        }
    }

    public void exitProgram(ActionEvent e){

        List<String> currentTasks=taskList.getItems();

        try{
            FileWriter writer =new FileWriter(filepath);
            for(String text: currentTasks){
                text+="\n";
                writer.write(text);
            }
            writer.close();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        System.exit(e);
    }
    
}
