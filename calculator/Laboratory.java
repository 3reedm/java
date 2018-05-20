import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;

class Calculator extends JFrame
{   
    Calculator(String title)
    {
        setTitle(title);
		setBounds(300, 300, 227,320);
        setResizable(false);
  
        addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {	
                    dispose();
                    System.exit(0);
                }
            }
        );
        
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Справка");
        JMenuItem about = new JMenuItem("О программе");
        
        JFrame aboutFrame = new JFrame("О программе");
        aboutFrame.setBounds(535, 350, 360, 285);
        aboutFrame.setResizable(false);
        JTextArea textArea = new JTextArea(); 
        textArea.setText("\n   Калькулятор 'Обычный'.\n"   +
                         "   Разработчик: Юсков Никита, 2014.\n" +
                         "   Сочетания Клавиш:\n" +
                         "     F9                              " +                   
                         "             Нажатие кнопки +/-\n" +
                         "     /                               " + 
                         "                Нажатие кнопки /\n" +
                         "     *                               " +
                         "               Нажатие кнопки *\n" +
                         "     +                               " + 
                         "               Нажатие кнопки +\n" +
                         "     -                               " +
                         "                Нажатие кнопки -\n" +
                         "     0-9                             " + 
                         "             Нажатие цифровых кнопок (0-9)\n" +
                         "     = или SPACE                     " + 
                         "   Нажатие кнопки =\n" +
                         "     . или ,                           " +
                         "          Нажатие кнопки ." +
                         "\n                                 " + 
                         "                    (десятичный разделитель)\n" +
                         "     BACKSPACE                       " + 
                         "  Нажатие кнопки ←\n" +
                         "     ESC или DEL или C           Нажатие кнопки C\n"
                        );
                        
        textArea.setBackground(new Color(235, 240, 251));
        textArea.setFocusable(false);
        textArea.setCursor(aboutFrame.getCursor());
        aboutFrame.add(textArea);
        about.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    aboutFrame.setVisible(true);
                }
            }
        );
        menu.add(about);
        bar.add(menu);       
        setJMenuBar(bar);
        
        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout); 
        JPanel numberPanel = new JPanel(new GridBagLayout());
        JPanel resultsPanel = new JPanel(new BorderLayout());
        GridBagConstraints generalOptions = new GridBagConstraints();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js"); 
        
        StringBuffer numberEdit = new StringBuffer();
        numberEdit.append('1');
        numberEdit.append('0');
        numberEdit.append('0');
        numberEdit.append('+');
        numberEdit.append(' ');
        Font fontNumber = new Font("Segoe UI", Font.BOLD, 10);
        Font fontArea = new Font("Consolas", Font.BOLD, 10);
        Dimension dimensionButton = new Dimension();
        dimensionButton.setSize(50, 25);
        Dimension dimensionAreaTop = new Dimension();
        dimensionAreaTop.setSize(200, 25);
        Dimension dimensionAreaBottom = new Dimension();
        dimensionAreaBottom.setSize(200, 35);
        JTextArea resultsTop = createArea("Top", fontArea, dimensionAreaTop);
        JTextArea resultsBottom = createArea("Bottom", fontArea, 
                                             dimensionAreaBottom);
        JButton button0 = createButton("0", fontNumber, dimensionButton);
        JButton button1 = createButton("1", fontNumber, dimensionButton);
        JButton button2 = createButton("2", fontNumber, dimensionButton);
        JButton button3 = createButton("3", fontNumber, dimensionButton);
        JButton button4 = createButton("4", fontNumber, dimensionButton);
        JButton button5 = createButton("5", fontNumber, dimensionButton);
        JButton button6 = createButton("6", fontNumber, dimensionButton);
        JButton button7 = createButton("7", fontNumber, dimensionButton);
        JButton button8 = createButton("8", fontNumber, dimensionButton);
        JButton button9 = createButton("9", fontNumber, dimensionButton);
        JButton buttonSum = createButton("+", fontNumber, dimensionButton);
        JButton buttonSub = createButton("-", fontNumber, dimensionButton);
        JButton buttonDiv = createButton("/", fontNumber, dimensionButton);
        JButton buttonMult = createButton("*", fontNumber, dimensionButton);
        JButton buttonRes = createButton("=", fontNumber, dimensionButton);
        JButton buttonDot = createButton(".", fontNumber, dimensionButton);
        JButton buttonClear = createButton("C", fontNumber, 
                                           dimensionButton);
        JButton buttonBack = createButton("←", fontNumber, dimensionButton);
        JButton buttonChange = createButton("±", fontNumber, dimensionButton);
        
        setNumberAction(button0, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button1, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button2, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button3, resultsTop, resultsBottom,
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button4, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button5, resultsTop, resultsBottom,
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button6, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button7, resultsTop, resultsBottom,
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button8, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(button9, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(buttonDot, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(buttonClear, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(buttonBack, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setNumberAction(buttonChange, resultsTop, resultsBottom, 
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit);
        setOperationAction(buttonSum, resultsTop, resultsBottom, 
                           dimensionAreaTop, dimensionAreaBottom,
                           numberEdit, engine);
        setOperationAction(buttonSub, resultsTop, resultsBottom,
                           dimensionAreaTop, dimensionAreaBottom,
                           numberEdit, engine);
        setOperationAction(buttonDiv, resultsTop, resultsBottom, 
                           dimensionAreaTop, dimensionAreaBottom,
                           numberEdit, engine);
        setOperationAction(buttonMult, resultsTop, resultsBottom,
                           dimensionAreaTop, dimensionAreaBottom,        
                           numberEdit, engine);
        setResultAction(buttonRes, resultsTop, resultsBottom,  
                        dimensionAreaTop, dimensionAreaBottom,
                        numberEdit, engine);
        
        Insets ins1 = new Insets(3, 3, 3, 3), ins2 = new Insets(3, 0, 3, 3), 
               ins3 = new Insets(3, 3, 3, 1), ins4 = new Insets(30, 0, 3, 3), 
               ins5 = new Insets(30, 3, 3, 3), ins6 = new Insets(30, 3, 3, 1);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 0;
        generalOptions.weightx = 0.5;
        generalOptions.weighty = 0.5;
        generalOptions.insets = ins4;
        numberPanel.add(buttonBack, generalOptions);
              
        generalOptions.gridx = 1;
        generalOptions.gridy = 0;
        generalOptions.insets = ins5;
        numberPanel.add(buttonClear, generalOptions);
                
        generalOptions.gridx = 2;
        generalOptions.gridy = 0;
        numberPanel.add(buttonChange, generalOptions);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 1;
        generalOptions.insets = ins2;
        numberPanel.add(button7, generalOptions);
        
        generalOptions.gridx = 1;
        generalOptions.gridy = 1;
        generalOptions.insets = ins1;
        numberPanel.add(button8, generalOptions);
        
        generalOptions.gridx = 2;
        generalOptions.gridy = 1;
        numberPanel.add(button9, generalOptions);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 2;
        generalOptions.insets = ins2;
        numberPanel.add(button4, generalOptions);
        
        generalOptions.gridx = 1;
        generalOptions.gridy = 2;
        generalOptions.insets = ins1;
        numberPanel.add(button5, generalOptions);
        
        generalOptions.gridx = 2;
        generalOptions.gridy = 2;
        numberPanel.add(button6, generalOptions);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 3;
        generalOptions.insets = ins2;
        numberPanel.add(button1, generalOptions);
        
        generalOptions.gridx = 1;
        generalOptions.gridy = 3;
        generalOptions.insets = ins1;
        numberPanel.add(button2, generalOptions);
        
        generalOptions.gridx = 2;
        generalOptions.gridy = 3;
        numberPanel.add(button3, generalOptions);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 4;
        generalOptions.insets = ins2;
        numberPanel.add(button0, generalOptions);
        
        generalOptions.gridx = 3;
        generalOptions.gridy = 0;
        generalOptions.insets = ins6;
        numberPanel.add(buttonDiv, generalOptions);
        
        generalOptions.gridx = 3;
        generalOptions.gridy = 1;
        generalOptions.insets = ins3;
        numberPanel.add(buttonMult, generalOptions);
        
        generalOptions.gridx = 3;
        generalOptions.gridy = 2;
        numberPanel.add(buttonSub, generalOptions);
        
        generalOptions.gridx = 3;
        generalOptions.gridy = 3;
        numberPanel.add(buttonSum, generalOptions);
                
        generalOptions.gridx = 3;
        generalOptions.gridy = 4;
        numberPanel.add(buttonDot, generalOptions);
        
        generalOptions.gridx = 1;
        generalOptions.gridy = 4;
        generalOptions.insets = ins1;
        generalOptions.anchor = GridBagConstraints.LAST_LINE_START & 
                                GridBagConstraints.PAGE_END & 
                                GridBagConstraints.LAST_LINE_END;
        buttonRes.setMinimumSize(new Dimension(96, 25));
        generalOptions.gridwidth = 3;
        numberPanel.add(buttonRes, generalOptions);
        
        generalOptions.gridx = 0;
        generalOptions.gridy = 0;
        generalOptions.weightx = 1;
        generalOptions.weighty = 0;
        generalOptions.anchor = GridBagConstraints.FIRST_LINE_START;
        generalOptions.insets = new Insets(13, 11, 0, 12);
        resultsPanel.setBorder(new LineBorder(new Color(150, 150, 150)));
        resultsPanel.add(resultsTop, BorderLayout.NORTH);
        resultsPanel.add(resultsBottom, BorderLayout.CENTER);
        add(resultsPanel, generalOptions);
       
        generalOptions.gridx = 0;
        generalOptions.gridy = 0;
        generalOptions.weightx = 0;
        generalOptions.weighty = 1;
        generalOptions.anchor = GridBagConstraints.CENTER;
        generalOptions.insets = new Insets(15, 11, 0, 11);
        add(numberPanel, generalOptions);
        
        numberPanel.setFocusable(true);
        ActionEvent event0 = new ActionEvent(button0, 0, "");
        ActionEvent event1 = new ActionEvent(button1, 0, "");
        ActionEvent event2 = new ActionEvent(button2, 0, "");
        ActionEvent event3 = new ActionEvent(button3, 0, "");
        ActionEvent event4 = new ActionEvent(button4, 0, "");
        ActionEvent event5 = new ActionEvent(button5, 0, "");
        ActionEvent event6 = new ActionEvent(button6, 0, "");
        ActionEvent event7 = new ActionEvent(button7, 0, "");
        ActionEvent event8 = new ActionEvent(button8, 0, "");
        ActionEvent event9 = new ActionEvent(button9, 0, "");
        ActionEvent eventClear = new ActionEvent(buttonClear, 0, "");
        ActionEvent eventChange = new ActionEvent(buttonChange, 0, "");
        ActionEvent eventBack = new ActionEvent(buttonBack, 0, "");
        ActionEvent eventRes = new ActionEvent(buttonRes, 0, "");
        ActionEvent eventSub = new ActionEvent(buttonSub, 0, "");
        ActionEvent eventSum = new ActionEvent(buttonSum, 0, "");
        ActionEvent eventMult = new ActionEvent(buttonMult, 0, "");
        ActionEvent eventDiv = new ActionEvent(buttonDiv, 0, "");
        ActionEvent eventDot = new ActionEvent(buttonDot, 0, "");
        numberPanel.addKeyListener(
            new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();

                    if (key == KeyEvent.VK_0)
                        button0.getActionListeners()[0].
                                actionPerformed(event0);
                    if (key == KeyEvent.VK_1)
                        button1.getActionListeners()[0].
                                actionPerformed(event1);
                    if (key == KeyEvent.VK_2)
                        button2.getActionListeners()[0].
                                actionPerformed(event2);
                    if (key == KeyEvent.VK_3)
                        button3.getActionListeners()[0].
                                actionPerformed(event3);
                    if (key == KeyEvent.VK_4)
                        button4.getActionListeners()[0].
                                actionPerformed(event4);
                    if (key == KeyEvent.VK_5)
                        button5.getActionListeners()[0].
                                actionPerformed(event5);
                    if (key == KeyEvent.VK_6)
                        button6.getActionListeners()[0].
                                actionPerformed(event6);
                    if (key == KeyEvent.VK_7)
                        button7.getActionListeners()[0].
                                actionPerformed(event7);
                    if (key == KeyEvent.VK_8)
                        button8.getActionListeners()[0].
                                actionPerformed(event8);
                    if (key == KeyEvent.VK_9)
                        button9.getActionListeners()[0].
                                actionPerformed(event9);
                    if (key == KeyEvent.VK_C || key == KeyEvent.VK_DELETE ||
                        key == KeyEvent.VK_ESCAPE)
                        buttonClear.getActionListeners()[0].
                                    actionPerformed(eventClear);
                    if (key == KeyEvent.VK_BACK_SPACE)
                        buttonBack.getActionListeners()[0].
                                   actionPerformed(eventBack);
                    if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER ||
                        (key == KeyEvent.VK_EQUALS && !e.isShiftDown()))
                        buttonRes.getActionListeners()[0].
                                  actionPerformed(eventRes);
                    if (key == KeyEvent.VK_MINUS)
                        buttonSub.getActionListeners()[0].
                                  actionPerformed(eventSub);
                    if (key == KeyEvent.VK_EQUALS && e.isShiftDown())
                        buttonSum.getActionListeners()[0].
                                  actionPerformed(eventSum);
                    if (key == KeyEvent.VK_MULTIPLY && e.isShiftDown())
                        buttonMult.getActionListeners()[0].
                                   actionPerformed(eventMult);
                    if (key == KeyEvent.VK_SLASH)
                        buttonDiv.getActionListeners()[0].
                                  actionPerformed(eventDiv);
                    if (key == KeyEvent.VK_COMMA || 
                        key == KeyEvent.VK_PERIOD)
                        buttonDot.getActionListeners()[0].
                                  actionPerformed(eventDot);
                    if (key == KeyEvent.VK_F9)
                        buttonChange.getActionListeners()[0].
                                     actionPerformed(eventChange);
                }
            }
        );
        
        setVisible(true);
    }
    
    public JButton createButton(String title, Font font, Dimension dimension) 
    {
        JButton button = new JButton(title);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
        button.setPreferredSize(dimension);
        button.setBorder(new LineBorder(new Color(150, 150, 150)));
        button.setBackground(new Color(220, 231, 249));
        if (title == "=")
            button.setFont(font.deriveFont(Font.BOLD, 22));
        else if (title == "+")
            button.setFont(font.deriveFont(Font.TRUETYPE_FONT, 14));
        else if (title == "*")
            button.setFont(font.deriveFont(Font.TRUETYPE_FONT, 17));
        else if (title == "/" || title == "C")
            button.setFont(font.deriveFont(Font.TRUETYPE_FONT, 11));
        else if (title == "←")
            button.setFont(font.deriveFont(Font.TRUETYPE_FONT, 22));
        else
            button.setFont(font.deriveFont(Font.TRUETYPE_FONT, 16));
        button.setFocusable(false);
        return button;
    }
    
    public JTextArea createArea(String title, Font font, Dimension dimension)
    {
        JTextArea area = new JTextArea();
        area.setFocusable(false);
        area.setCursor(getCursor());
        area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        area.setBackground(new Color(235, 240, 251));
        
        if (title == "Top") {
            area.setMinimumSize(dimension);
            area.setMaximumSize(dimension);
            area.setPreferredSize(dimension);
            area.setFont(font.deriveFont(Font.PLAIN, 12));
        }
        else if (title == "Bottom") {
            area.setMinimumSize(dimension);
            area.setMaximumSize(dimension);
            area.setPreferredSize(dimension);
            area.setFont(font.deriveFont(Font.PLAIN, 24));
            area.setText("0");
        }

        return area;
    }
    
    public void setNumberAction(JButton button, JTextArea resultsAreaTop, 
                                JTextArea resultsAreaBottom,
                                Dimension dimensionAreaTop, 
                                Dimension dimensionAreaBottom,
                                StringBuffer numberEdit) 
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String text = button.getText();
                    char numberEditChar = numberEdit.charAt(0);
                    char numberEditGood = numberEdit.charAt(1);
                    String textBottom = resultsAreaBottom.getText();
                    int lengthBottom = textBottom.length();
                    boolean flagMinus = false;
                    boolean flagDot = false; 
                    if (numberEditChar == '1' &&
                        textBottom.charAt(lengthBottom-1) == '-') {
                            textBottom = textBottom.substring
                                                    (0, lengthBottom-1);
                            lengthBottom = lengthBottom - 1;
                            flagMinus = true;
                        }
                    if (numberEditChar == '1' && numberEditGood == '1' && 
                        text.charAt(0) != '.')
                        if (textBottom.charAt(0) == '.') {
                            resultsAreaBottom.setText(textBottom.substring(1) +
                                                      '.');
                            numberEdit.setCharAt(1, '0');
                            flagDot = true;
                        }
                    if (text == "C") {
                        resultsAreaBottom.setText("0");
                        resultsAreaTop.setText("");
                        if (numberEditChar == '0')
                            numberEdit.setCharAt(0, '1');
                        numberEdit.replace(4, numberEdit.length(), " ");
                    }
                    else if (text == "±") {
                        if (numberEditChar == '1') {
                            if (flagMinus)
                                resultsAreaBottom.setText(textBottom);
                            else {
                                resultsAreaBottom.setText(textBottom + "-");
                            }
                            
                            if (textBottom.charAt(0) == '.')
                                numberEdit.setCharAt(2, '1');
                        }
                    }
                    else if (text == "←") {
                        if (numberEditChar == '1') {
                            if (lengthBottom == 1)
                                resultsAreaBottom.setText("0");
                            else {
                                if (numberEdit.charAt(2) == '1') {
                                    textBottom = textBottom.
                                                 substring(1, lengthBottom) +
                                                 '.';
                                    numberEdit.setCharAt(2, '0'); 
                                }
                                String textEnd = textBottom.substring(
                                                    0, lengthBottom-1);
                                int lengthEnd = textEnd.length();
                                if (textEnd.charAt(lengthEnd-1) == '.') {
                                    resultsAreaBottom.setText('.' + 
                                                              textEnd.substring
                                                              (0, lengthEnd-1)
                                                             );
                                    if (flagMinus)
                                        resultsAreaBottom.append("-");
                                    numberEdit.setCharAt(2, '1');
                                }
                                else {
                                    resultsAreaBottom.setText(textEnd);
                                    if (flagMinus)
                                        resultsAreaBottom.append("-");
                                }
                            }
                        }
                    }
                    else if (text == ".") {
                        if (numberEditChar == '1') {
                            if (textBottom.indexOf('.') == -1) {
                                if (numberEditChar == '1') {
                                    resultsAreaBottom.insert(".", 0);
                                    numberEdit.setCharAt(1, '1');
                                }
                                else {
                                    if (textBottom == "")
                                        resultsAreaBottom.setText("0.");
                                    else
                                        resultsAreaBottom.insert(".", 0);
                                    numberEdit.setCharAt(0, '1');
                                    numberEdit.setCharAt(1, '1');
                                }
                            }
                        }
                        if (numberEditChar == '0') {
                            resultsAreaBottom.setText(".0");
                            numberEdit.setCharAt(0, '1');
                            numberEdit.setCharAt(1, '1');
                        }
                    }
                    else {
                        char number = textBottom.charAt(0);
                        if ((number == '0' && lengthBottom == 1) || 
                             numberEditChar == '0') {
                            if (flagMinus)
                                resultsAreaBottom.setText(
                                    text + '-'); 
                            else {
                                resultsAreaBottom.setText(text);
                                if (numberEditChar == '0')
                                    numberEdit.setCharAt(0, '1');
                            }
                        }
                        else {
                            if (flagMinus && !flagDot) {
                                if (numberEdit.charAt(2) == '1') {
                                    textBottom = textBottom.substring
                                                 (1, lengthBottom) +
                                                 '.' + text + '-';
                                    numberEdit.setCharAt(2, '0'); 
                                    resultsAreaBottom.setText(textBottom);
                                }
                                else 
                                    resultsAreaBottom.setText(
                                        textBottom + text + '-');
                            }
                            else if (flagMinus && flagDot) {
                                resultsAreaBottom.setText(
                                    textBottom.substring(1, lengthBottom) + 
                                    '.' + text + 
                                    '-');
                            }  
                            else {
                                if (numberEdit.charAt(2) == '1') {
                                    textBottom = textBottom.substring
                                                 (1, lengthBottom) +
                                                 '.' + text;
                                    numberEdit.setCharAt(2, '0'); 
                                    resultsAreaBottom.setText(textBottom);
                                }
                                else 
                                    resultsAreaBottom.append(text);
                            }
                        }    
                    }
                    
                    Font font = resultsAreaBottom.getFont();
                    text = resultsAreaBottom.getText(); 
                    lengthBottom = text.length();
                    if (lengthBottom > 10 || text.indexOf('E') != -1) { 
                        resultsAreaBottom.setFont(
                            font.deriveFont(Font.PLAIN, 14));
                        dimensionAreaBottom.setSize(200, 25);
                        resultsAreaBottom.setSize(dimensionAreaBottom);
                        dimensionAreaTop.setSize(200, 35);
                        resultsAreaTop.setSize(dimensionAreaTop);
                    }
                    else {
                        resultsAreaBottom.setFont(
                            font.deriveFont(Font.PLAIN, 24));
                        dimensionAreaBottom.setSize(200, 35);
                        resultsAreaBottom.setSize(dimensionAreaBottom);
                        dimensionAreaTop.setSize(200, 25);
                        resultsAreaTop.setSize(dimensionAreaTop);
                    }
                }
            }
        );
    }
    
    public void setOperationAction(JButton button, JTextArea resultsAreaTop, 
                                   JTextArea resultsAreaBottom,
                                   Dimension dimensionAreaTop, 
                                   Dimension dimensionAreaBottom,
                                   StringBuffer numberEdit, 
                                   ScriptEngine engine) 
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String textTop = resultsAreaTop.getText();
                    String textBottom = resultsAreaBottom.getText();
                    String textButton = button.getText();
                    String text = "";
                    
                    if (textBottom.charAt(0) == '.') {
                        textBottom = textBottom.substring(1);
                        resultsAreaBottom.setText(textBottom);
                    }
                    int lengthTop = textTop.length();
                    numberEdit.setCharAt(3, textButton.charAt(0));
                    if (numberEdit.charAt(0) == '1' || lengthTop == 0) {
                        if (lengthTop == 0)
                            text = textButton + ' ' + textBottom;
                        else {
                            text = textBottom + ' ' + textTop;
                            String[] textResults = text.split(" ");
                            int lengthRes = textResults.length;
                            int i;
                            text = "";
                            for (i=lengthRes - 1; i>=0; --i) {
                                if ((textResults[i].indexOf('-') != -1 && 
                                     textResults[i].indexOf('E') == -1) || 
                                    (textResults[i].indexOf('-') != -1 && 
                                     textResults[i].indexOf('E') != -1 && 
                                     textResults[i].lastIndexOf('-') != -1 &&
                                     textResults[i].indexOf('-') != 
                                     textResults[i].lastIndexOf('-')))
                                    textResults[i] = 
                                        " - " + 
                                        textResults[i].substring(0, 
                                            textResults[i].length()-1);
                                text = text + textResults[i];
                            }
                            
                            try {
                                text = engine.eval(text).toString();
                            }
                            catch (ScriptException exception) {}
                            
                            if ((text.indexOf('-') != -1 && 
                                 text.indexOf('E') == -1) || 
                                (text.indexOf('-') != -1 && 
                                 text.indexOf('E') != -1 && 
                                 text.lastIndexOf('-') != -1 &&
                                 text.indexOf('-') != text.lastIndexOf('-')))
                                text = text.substring(1) + '-';
                            
                            int shift = text.indexOf('.');
                            if (shift != -1) {
                                String textShift = text.substring(shift+1);
                                int lengthShift = textShift.length();
                                if (lengthShift == 1 && 
                                    textShift.charAt(0) == '0')
                                    text = text.substring(0, shift);
                            }
                                
                            resultsAreaBottom.setText(text);     

                            Font font = resultsAreaBottom.getFont(); 
                            int lengthBottom = text.length();
                            if (lengthBottom > 10 || text.indexOf('E') != -1) { 
                                resultsAreaBottom.setFont(
                                    font.deriveFont(Font.PLAIN, 14));
                                dimensionAreaBottom.setSize(200, 25);
                                resultsAreaBottom.setSize(dimensionAreaBottom);
                                dimensionAreaTop.setSize(200, 35);
                                resultsAreaTop.setSize(dimensionAreaTop);
                            }
                            else {
                                resultsAreaBottom.setFont(
                                    font.deriveFont(Font.PLAIN, 24));
                                dimensionAreaBottom.setSize(200, 35);
                                resultsAreaBottom.setSize(dimensionAreaBottom);
                                dimensionAreaTop.setSize(200, 25);
                                resultsAreaTop.setSize(dimensionAreaTop);
                            }
                            
                            text = textButton + ' ' + textBottom + ' ' + 
                                   textTop;
                        }
                        numberEdit.setCharAt(0, '0');
                        resultsAreaTop.setText(text);
                    }
                    else {
                        resultsAreaTop.replaceRange(textButton, 0, 1);
                    }
                }
            }
        );
    }
    
    public void setResultAction(JButton button, JTextArea resultsAreaTop, 
                                JTextArea resultsAreaBottom,
                                Dimension dimensionAreaTop, 
                                Dimension dimensionAreaBottom,
                                StringBuffer numberEdit,
                                ScriptEngine engine) 
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String textTop = resultsAreaTop.getText();
                    String textBottom = resultsAreaBottom.getText();
                    String text = "";
                    resultsAreaTop.setText("");
                    
                    int lengthTop = textTop.length();
                    if (textBottom.charAt(0) == '.')
                        textBottom = textBottom.substring(1);
                        
                    if (lengthTop == 0 && numberEdit.charAt(4) == ' ')
                        text = textBottom;
                    else if (lengthTop == 0 && numberEdit.charAt(4) != ' ') {
                        if (numberEdit.charAt(3) != '-' && 
                            numberEdit.charAt(3) != '/')
                            text = textBottom + ' ' + numberEdit.charAt(3) + 
                                   ' ' + numberEdit.substring(4);
                        else
                            text = numberEdit.substring(4) + ' ' + 
                                   numberEdit.charAt(3) + ' ' + textBottom;
                    }
                    else
                        text = textBottom + ' ' + textTop;
                    String[] textResults = text.split(" ");
                    int i;
                    text = "";
                    
                    int shift, lengthShift;
                    int lengthRes = textResults.length;
                    for (i=lengthRes - 1; i>=0; --i) {
                        if ((textResults[i].indexOf('-') != -1 && 
                             textResults[i].indexOf('E') == -1) || 
                            (textResults[i].indexOf('-') != -1 && 
                             textResults[i].indexOf('E') != -1 && 
                             textResults[i].lastIndexOf('-') != -1 &&
                             textResults[i].indexOf('-') != 
                             textResults[i].lastIndexOf('-')))
                            textResults[i] = 
                                " - " + 
                                textResults[i].substring(0, 
                                    textResults[i].length()-1);
                        text = text + textResults[i];
                    }
                    
                    try {
                        text = engine.eval(text).toString();
                    }
                    catch (ScriptException exception) {}
                    
                    if ((text.indexOf('-') != -1 && 
                         text.indexOf('E') == -1) || 
                        (text.indexOf('-') != -1 && 
                         text.indexOf('E') != -1 && 
                         text.lastIndexOf('-') != -1 &&
                         text.indexOf('-') != text.lastIndexOf('-')))
                        text = text.substring(1) + '-';
                    
                    shift = text.indexOf('.');
                    if (shift != -1) {
                        String textShift = text.substring(shift+1);
                        lengthShift = textShift.length();
                        if (lengthShift == 1 && textShift.charAt(0) == '0')
                            text = text.substring(0, shift);
                    }
                    if (numberEdit.charAt(0) == '1')
                        numberEdit.setCharAt(0, '0');
                    if (lengthTop != 0) {
                        resultsAreaBottom.setText(text);
                        numberEdit.replace(4, numberEdit.length(), 
                                           textBottom);
                    }
                    else {
                        if (textBottom.charAt(0) == '.')
                            resultsAreaBottom.setText(textBottom.substring
                                                       (1, 
                                                        textBottom.length())
                                                      );
                        else
                            resultsAreaBottom.setText(text);
                    }
                    
                    Font font = resultsAreaBottom.getFont();
                    text = resultsAreaBottom.getText(); 
                    int lengthBottom = text.length();
                    if (lengthBottom > 10 || text.indexOf('E') != -1) { 
                        resultsAreaBottom.setFont(
                            font.deriveFont(Font.PLAIN, 14));
                        dimensionAreaBottom.setSize(200, 25);
                        resultsAreaBottom.setSize(dimensionAreaBottom);
                        dimensionAreaTop.setSize(200, 35);
                        resultsAreaTop.setSize(dimensionAreaTop);
                    }
                    else {
                        resultsAreaBottom.setFont(
                            font.deriveFont(Font.PLAIN, 24));
                        dimensionAreaBottom.setSize(200, 35);
                        resultsAreaBottom.setSize(dimensionAreaBottom);
                        dimensionAreaTop.setSize(200, 25);
                        resultsAreaTop.setSize(dimensionAreaTop);
                    }
                }
            }
        );
    }
}

class Laboratory 
{
    public static void main(String[] args) 
    {   
        Calculator simple = new Calculator("Калькулятор");    
    }
}