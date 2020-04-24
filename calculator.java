package ejercicio_poo_ddr_1;
import java.awt.Color;//clase color 
import java.awt.Container;//poner un contenedor 
import java.awt.FlowLayout;//poner en modo horizontal
import java.awt.event.ActionEvent;//es para los eventos 
import java.awt.event.ActionListener;//interface para lo eventos
import javax.swing.*;//para usar los botones label,textfield,textbooton

public class calculator extends JFrame implements ActionListener
{
    private JButton btnsuma,btnresta,btnmulti,btndiv,btnlimpiar,btnrpta,btnsalir,nada;//botones que se mostrara en pantalla para interactuar
    private JTextField valor1,valor2,camporesultado;//campos para poner digitos
    JLabel label1,label2;

    public void Controles()
    {
   
        Container contenedor = getContentPane();
        contenedor.setLayout( new FlowLayout());// se acomoda de forma horizontal
        label1 = new JLabel("Numero 1");
        contenedor.add(label1);
        valor1 = new JTextField(10);
        contenedor.add(valor1);
        label2 = new JLabel("Numero 2");
        contenedor.add(label2);
        valor2 = new JTextField(10);
        contenedor.add(valor2);
        nada = new JButton(" ");
        
        btnsuma = new JButton("+");
        contenedor.add(btnsuma);//BOTON SUMA
        btnsuma.addActionListener(this);//pARA QUE ESTE PENDIENTE AL MOMENTO DE DAR UN CLICK
        btnresta = new JButton("-");
        contenedor.add(btnresta);//BOTON RESTA
        btnresta.addActionListener(this);
        btnmulti = new JButton("x");
        contenedor.add(btnmulti);
        btnmulti.addActionListener(this);
        btndiv = new JButton("/");
        btndiv.addActionListener(this);
        contenedor.add(btndiv);
        btnrpta=new JButton("Rpta.");
        btnrpta.addActionListener(this);
        contenedor.add(btnrpta);
        camporesultado = new JTextField(10);
        contenedor.add(camporesultado);
        btnlimpiar = new JButton("Limpiar");
        contenedor.add(btnlimpiar);
        btnlimpiar.addActionListener(this);
    }
      //CONSTRCUTOR SE LLAMA IGUAL DE QUE LA CLASE
    public calculator()
    {
  
        super("calculator_KAOP");//NOMNRE EN EL PANEL SUPERIOR 
        //cargo controles
        Controles();
        setSize(1000,80);
        setLocationRelativeTo(null);//Centrar ventana
        setVisible(true);
    }
     
 public void actionPerformed(ActionEvent e) {//actionPerformed pertenece al metodo acction LISTENER
    double  num1,num2,resu;
    String resultado;
       if (e.getSource()==btnsuma) {//OBJEOS "e" nos va a decir a que le presionamos , con el metodo "getSource " nos doira si se presiono el boton btnsuma
        if(valor1.getText().equals("") || valor2.getText().equals(""))//getText : nos indica que hay dentro del campo y lo va a leer como un string
                                                                       //equals: verific si esta vacio ese campo
        {
         JOptionPane.showMessageDialog(null, ".-.Los datos no están completos",//un mensaje por tantalla
         "Error",JOptionPane.WARNING_MESSAGE); //WARNING_MESSAGE: muestra un mensaje de error por pantalla-> hay varios tipos para escoger.
        }
        else{
         num1=Double.parseDouble(valor1.getText());//al momento de almacenar un valor se almacena de tipo string por ese motivo se uns el "parseDouble" para convertir el valor ingresado que es string  a entero
         num2=Double.parseDouble(valor2.getText());
         resu=num1+num2;
         resultado=String.valueOf(resu);//valueOf: convierte un valor de tipo double a string para poner mostar en el campo textfield por pantalla
         camporesultado.setText(resultado);//metodo setText pondremos en el "camporesultado" el resultado de la opereacion
        }          
       }
       if (e.getSource()==btnresta) {// si se presiono el de la resta
        if(valor1.getText().equals("") || valor2.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Los datos no están completos",
         "Error",JOptionPane.ERROR_MESSAGE); 
        }
        else{
         num1=Double.parseDouble(valor1.getText()); 
         num2=Double.parseDouble(valor2.getText());
         resu=num1-num2;
         resultado=String.valueOf(resu);
         camporesultado.setText(resultado);
        }          
       } 
       if (e.getSource()==btnmulti) {// si se presiono el de la multiplicacion
        if(valor1.getText().equals("") || valor2.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Los datos no están completos",
         "Error",JOptionPane.ERROR_MESSAGE); 
        }
        else{
         num1=Double.parseDouble(valor1.getText());
         num2=Double.parseDouble(valor2.getText());
         resu=num1*num2;
         resultado=String.valueOf(resu);
         camporesultado.setText(resultado);
        }          
       }
       if (e.getSource()==btndiv) {
        if(valor1.getText().equals("") || valor2.getText().equals(""))
        {
         JOptionPane.showMessageDialog(null, "Los datos no están Incompletos",
         "Error",JOptionPane.ERROR_MESSAGE);
        }
        
        else{
         num1=Double.parseDouble(valor1.getText());
         num2=Double.parseDouble(valor2.getText());
         try{
          resu=num1/num2;
          resultado=String.valueOf(resu);
          camporesultado.setText(resultado);
         }
         catch(ArithmeticException ex){//se genera una exeption aritmetica, y luego muestra un menaje que error
           JOptionPane.showMessageDialog(null, "División entre cero NO PERMITIDA!",
           "Error",JOptionPane.ERROR_MESSAGE);
         }
          
        }  
       }
      
               
       
       if (e.getSource()==btnlimpiar){
        valor1.setText("");//pone en blano(valor vacio) si preioneamos el boton limpiar
           valor2.setText("");
           camporesultado.setText("");
      } 
       if(e.getSource()==btnsalir)
       {
        System.exit(0);   //se cierrra el programa
       }
   }
    
   public static void main(String[] args) {
     JFrame.setDefaultLookAndFeelDecorated(true);//decoracon con look an field
     calculator calc = new calculator();//Instanciamos la clase que creamos, se crea un objeto de tipo calculadora 
     calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar ventana, al momento de cerrar el programa se 
   }
}