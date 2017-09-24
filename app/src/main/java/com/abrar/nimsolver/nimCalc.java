public class nimCalc{

public String solveGrid(String input){
//Scanner scan = new Scanner(System.in);
//System.out.println("Enter Stack values: (comma separated)");
//String stacks = scan.nextLine();
String[] rawStack = input.split(",");
String[] board = new String[rawStack.length];
int max = -1;
for (int i = 0; i < rawStack.length; i++){
rawStack[i] = rawStack[i].trim();  
board[i] = Integer.toString(Integer.parseInt(rawStack[i]), 2);
if(max < board[i].length())
  max = board[i].length();

}

for (int j = 0; j < rawStack.length; j++){
  while(board[j].length() < max){
  board[j] = "0" + board[j];
  }
  
}

int[] X = new int[max];
for (int o = 0; o < max; o++){
  int count = 0;
  for (int k = 0; k < rawStack.length; k++){
  if (board[k].charAt(o) == '1')
    count++;
  }
  X[o] = count%2;
}


int[] result = new int[rawStack.length];

for (int q = 0; q < rawStack.length; q++){
String binary = "";
for (int w = 0; w < max; w++){
binary = binary + String.valueOf((X[w] + (int)(board[q].charAt(w)))%2);
}
if(Integer.parseInt(board[q], 2) > Integer.parseInt(binary, 2)){
  return "Remove " + (Integer.parseInt(board[q], 2)-Integer.parseInt(binary, 2)) + " from stack " + (q+1);
  
}
 
}
return "No moves";
}
}