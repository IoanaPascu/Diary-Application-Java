package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import packets.loginPacket;
import packets.loginResponsePacket;
import packets.signupPacket;


public class ClientS extends javax.swing.JFrame {
    
    static Connection DBConnection; // connection to the database
    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private HashMap<Integer, Entry> ENTRIES;
    private User USER;
    private Settings SETTINGS;
    private boolean loggedIn = false;
    
    public ClientS() {
        connectToServer();        
        initComponents();   
        //dialogBox.setVisible(true);
    }
    
    public boolean connectToServer(){
        try {
            socket = new Socket("localhost", 65535);            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();        
            JOptionPane.showMessageDialog(null, "Could not connect to server. Try again later.");
            return false;
        }
      
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogBox = new javax.swing.JDialog();
        loginContainer = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginUsernameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        switchToSignupButton = new javax.swing.JButton();
        loginErrorLabel = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();
        signupPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        signupUsernameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        switchToLoginButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        signupErrorLabel = new javax.swing.JLabel();
        signupPasswordField = new javax.swing.JPasswordField();
        confirmSignupPasswordField = new javax.swing.JPasswordField();
        MenuPanel = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        calendarButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        appearancelButton = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        userProfilePanel = new javax.swing.JPanel();
        editProfileButton = new javax.swing.JButton();
        chooseProfilePicButton = new javax.swing.JButton();
        profilePicLabel = new javax.swing.JLabel();
        profileNameField = new javax.swing.JTextField();
        profileBirthdateField = new javax.swing.JTextField();
        editProfilePanel = new javax.swing.JPanel();
        settingsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        appearancePanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();
        calendarContainerPanel = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        timelinePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addEntryButton = new javax.swing.JButton();

        dialogBox.setTitle("Login");
        dialogBox.setLocation(new java.awt.Point(50, 50));
        dialogBox.setMaximumSize(new java.awt.Dimension(329, 411));
        dialogBox.setModal(true);
        dialogBox.setPreferredSize(new java.awt.Dimension(329, 411));
        dialogBox.setResizable(false);
        dialogBox.setSize(new java.awt.Dimension(329, 490));
        dialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                dialogBoxWindowDeactivated(evt);
            }
        });
        dialogBox.getContentPane().setLayout(new java.awt.CardLayout());

        loginContainer.setLayout(new java.awt.CardLayout());

        loginPanel.setMaximumSize(new java.awt.Dimension(329, 411));
        loginPanel.setMinimumSize(new java.awt.Dimension(329, 411));

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel1.setText("Diary App");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Login");

        loginUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Password:");

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        switchToSignupButton.setText("Switch to Signup");
        switchToSignupButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToSignupButtonActionPerformed(evt);
            }
        });

        loginErrorLabel.setForeground(new java.awt.Color(204, 0, 0));
        loginErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(1965, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(1933, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(switchToSignupButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(loginPasswordField)))
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(loginErrorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addGap(42, 42, 42))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(switchToSignupButton)
                .addContainerGap(1227, Short.MAX_VALUE))
        );

        loginContainer.add(loginPanel, "card2");

        signupPanel.setMaximumSize(new java.awt.Dimension(329, 411));
        signupPanel.setMinimumSize(new java.awt.Dimension(329, 411));

        jLabel5.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel5.setText("Diary App");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Username:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Signup");

        signupUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupUsernameFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Password:");

        signupButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupButton.setText("Sign up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        switchToLoginButton.setText("Switch to Login");
        switchToLoginButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToLoginButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Confirm password:");

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(signupUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(signupPasswordField)
                                    .addComponent(confirmSignupPasswordField))
                                .addGap(8, 8, 8))
                            .addComponent(switchToLoginButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(signupErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signupButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62))))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(confirmSignupPasswordField))
                .addGap(37, 37, 37)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(switchToLoginButton)
                .addContainerGap())
        );

        loginContainer.add(signupPanel, "card2");

        dialogBox.getContentPane().add(loginContainer, "card4");

        dialogBox.getAccessibleContext().setAccessibleParent(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setSize(new java.awt.Dimension(1200, 650));

        MenuPanel.setBackground(new java.awt.Color(255, 102, 102));
        MenuPanel.setLayout(new java.awt.GridBagLayout());

        profileButton.setText("Profile");
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        profileButton.setPreferredSize(new java.awt.Dimension(100, 40));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(profileButton, gridBagConstraints);

        calendarButton.setText("Calendar");
        calendarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calendarButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        calendarButton.setPreferredSize(new java.awt.Dimension(100, 40));
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(calendarButton, gridBagConstraints);

        settingsButton.setText("Settings");
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        settingsButton.setPreferredSize(new java.awt.Dimension(100, 40));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(settingsButton, gridBagConstraints);

        appearancelButton.setText("Appearance");
        appearancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appearancelButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        appearancelButton.setPreferredSize(new java.awt.Dimension(100, 40));
        appearancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appearancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(appearancelButton, gridBagConstraints);

        getContentPane().add(MenuPanel, java.awt.BorderLayout.WEST);

        ContentPanel.setLayout(new java.awt.CardLayout());

        profilePanel.setLayout(new java.awt.CardLayout());

        editProfileButton.setText("Edit profile");
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        chooseProfilePicButton.setText("Choose profile pic");
        chooseProfilePicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseProfilePicButtonActionPerformed(evt);
            }
        });

        profilePicLabel.setBackground(new java.awt.Color(255, 204, 204));

        profileNameField.setText("Your Name Here");

        profileBirthdateField.setText("Your Birthdate Here");

        javax.swing.GroupLayout userProfilePanelLayout = new javax.swing.GroupLayout(userProfilePanel);
        userProfilePanel.setLayout(userProfilePanelLayout);
        userProfilePanelLayout.setHorizontalGroup(
            userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfilePanelLayout.createSequentialGroup()
                .addGap(458, 458, 458)
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 577, Short.MAX_VALUE)
                .addComponent(editProfileButton)
                .addGap(21, 21, 21))
            .addGroup(userProfilePanelLayout.createSequentialGroup()
                .addGroup(userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userProfilePanelLayout.createSequentialGroup()
                        .addGap(584, 584, 584)
                        .addComponent(chooseProfilePicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userProfilePanelLayout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userProfilePanelLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userProfilePanelLayout.setVerticalGroup(
            userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfilePanelLayout.createSequentialGroup()
                .addGroup(userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userProfilePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editProfileButton))
                    .addGroup(userProfilePanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(chooseProfilePicButton)
                .addGap(18, 18, 18)
                .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1278, Short.MAX_VALUE))
        );

        profilePanel.add(userProfilePanel, "card2");

        javax.swing.GroupLayout editProfilePanelLayout = new javax.swing.GroupLayout(editProfilePanel);
        editProfilePanel.setLayout(editProfilePanelLayout);
        editProfilePanelLayout.setHorizontalGroup(
            editProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
        );
        editProfilePanelLayout.setVerticalGroup(
            editProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );

        profilePanel.add(editProfilePanel, "card2");

        ContentPanel.add(profilePanel, "card2");

        jLabel11.setText("Account Settings");

        changePasswordButton.setText("Change password");

        jButton1.setText("Erase all data from my account");

        deleteAccountButton.setText("Delete my account");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAccountButton)
                    .addComponent(jButton1)
                    .addComponent(changePasswordButton)
                    .addComponent(jLabel11))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel11)
                .addGap(52, 52, 52)
                .addComponent(changePasswordButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(deleteAccountButton)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        ContentPanel.add(settingsPanel, "card2");

        appearancePanel.setBackground(new java.awt.Color(0, 0, 204));
        appearancePanel.setLayout(new java.awt.GridBagLayout());
        ContentPanel.add(appearancePanel, "card2");

        calendarPanel.setBackground(new java.awt.Color(153, 102, 255));
        calendarPanel.setLayout(new java.awt.BorderLayout());

        calendarContainerPanel.add(jCalendar1);

        calendarPanel.add(calendarContainerPanel, java.awt.BorderLayout.WEST);

        timelinePanel.setBackground(new java.awt.Color(102, 255, 102));
        timelinePanel.setPreferredSize(new java.awt.Dimension(136, 500));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Timeline");

        addEntryButton.setText("Add entry");

        javax.swing.GroupLayout timelinePanelLayout = new javax.swing.GroupLayout(timelinePanel);
        timelinePanel.setLayout(timelinePanelLayout);
        timelinePanelLayout.setHorizontalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGroup(timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timelinePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10))
                    .addGroup(timelinePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addEntryButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        timelinePanelLayout.setVerticalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(addEntryButton)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        calendarPanel.add(timelinePanel, java.awt.BorderLayout.EAST);

        ContentPanel.add(calendarPanel, "card2");

        getContentPane().add(ContentPanel, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changeCard(String card) {
        ContentPanel.removeAll();
        switch(card){
            case "profile": ContentPanel.add(profilePanel);
                     break;
            case "calendar": ContentPanel.add(calendarPanel);
                     break;
            case "settings":  ContentPanel.add(settingsPanel);
                     break;
            case "appearance": ContentPanel.add(appearancePanel);
                     break;            
        }
        ContentPanel.repaint();
        ContentPanel.revalidate();
    }
    
    private void changeCardDialog(String card) {
        loginContainer.removeAll();
        switch(card){
            case "login": loginContainer.add(loginPanel);
                     break;
            case "signup": loginContainer.add(signupPanel);
                     break;          
        }
        loginContainer.repaint();
        loginContainer.revalidate();
    }
    
    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        changeCard("profile");
    }//GEN-LAST:event_profileButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        changeCard("calendar");
    }//GEN-LAST:event_calendarButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        changeCard("settings");
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void appearancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appearancelButtonActionPerformed
        changeCard("appearance");
    }//GEN-LAST:event_appearancelButtonActionPerformed

    private void loginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameFieldActionPerformed

    private void loadProfile() {
        // profile pic
        int width = profilePicLabel.getWidth();
        int height = profilePicLabel.getHeight();
        profilePicLabel.setIcon(scaleImage(USER.getProfilePic(), width, height));
        
        // name
        profileNameField.setText(USER.getName());
        
        // birthdate
        profileBirthdateField.setText(USER.getBirthdate().toString());
    }
    
    private void loadSettings() {
        
    }
    
    private void loadAll() {
        loadProfile();
        loadSettings();
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String user = loginUsernameField.getText();
            String pass = String.valueOf(loginPasswordField.getPassword());
            
            loginPacket p = new loginPacket(user, pass);
            oos.writeObject(p);
            oos.flush();
            loginResponsePacket message = (loginResponsePacket) ois.readObject();
            
            if(message.getUser() != null) {
                loggedIn = true;
                ENTRIES = message.getEntries();
                USER = message.getUser();
                SETTINGS = message.getSettings();
                
                loadAll();
                
                dialogBox.setVisible(false);
            }            
            else {
                loginErrorLabel.setText("Credentials are incorrect!");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    // if we close the login modal we exit the app
    private void dialogBoxWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogBoxWindowDeactivated
        if(loggedIn == false)
            this.dispose();
    }//GEN-LAST:event_dialogBoxWindowDeactivated

    private void signupUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupUsernameFieldActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        try {
            String user = signupUsernameField.getText();
            String pass = String.valueOf(signupPasswordField.getPassword());
            String conf_pass = String.valueOf(confirmSignupPasswordField.getPassword());
            
            if(!(Objects.equals(pass, conf_pass))) {
                signupErrorLabel.setText("Passwords do not match!");
                return;
            }
            
            signupPacket p = new signupPacket(user, pass);
            oos.writeObject(p);
            oos.flush();
            int msg =  (int) ois.readObject();
            
            if(msg == 1) {
                JOptionPane.showMessageDialog(null, "User successfully created!");
                changeCardDialog("login");
                signupUsernameField.setText("");
                signupPasswordField.setText("");
                confirmSignupPasswordField.setText("");
            }            
            else 
                if(msg == -1) {
                    signupErrorLabel.setText("Username already exists.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error at signing up.");
                }
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    private void switchToSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToSignupButtonActionPerformed
        changeCardDialog("signup");
    }//GEN-LAST:event_switchToSignupButtonActionPerformed

    private void switchToLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToLoginButtonActionPerformed
        changeCardDialog("login");
    }//GEN-LAST:event_switchToLoginButtonActionPerformed

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        profilePanel.removeAll();
        profilePanel.add(editProfilePanel);                   
        profilePanel.repaint();
        profilePanel.revalidate();
    }//GEN-LAST:event_editProfileButtonActionPerformed

    // scales image to width w and height h
    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    private void chooseProfilePicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseProfilePicButtonActionPerformed
        JFileChooser profilePicChooser = new JFileChooser();
        int result = profilePicChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = profilePicChooser.getSelectedFile();
            try {
                int width = profilePicLabel.getWidth();
                int height = profilePicLabel.getHeight();
                ImageIcon profilePic = scaleImage(new ImageIcon(ImageIO.read(file)), width, height);
                
                profilePicLabel.setIcon(profilePic);
                USER.setProfilePic(profilePic);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        profilePicChooser.revalidate();
        profilePicChooser.repaint();
    }//GEN-LAST:event_chooseProfilePicButtonActionPerformed
    
    private String getMonthFormat(String m) {       
        if(m.length() == 1) 
            return "0" +  m; // months are indexed from 0 in the month picker
        return m;
    } 
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientS().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton addEntryButton;
    private javax.swing.JPanel appearancePanel;
    private javax.swing.JButton appearancelButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calendarButton;
    private javax.swing.JPanel calendarContainerPanel;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton chooseProfilePicButton;
    private javax.swing.JPasswordField confirmSignupPasswordField;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JDialog dialogBox;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JPanel editProfilePanel;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginContainer;
    private javax.swing.JLabel loginErrorLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JTextField loginUsernameField;
    private javax.swing.JTextField profileBirthdateField;
    private javax.swing.JButton profileButton;
    private javax.swing.JTextField profileNameField;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupErrorLabel;
    private javax.swing.JPanel signupPanel;
    private javax.swing.JPasswordField signupPasswordField;
    private javax.swing.JTextField signupUsernameField;
    private javax.swing.JButton switchToLoginButton;
    private javax.swing.JButton switchToSignupButton;
    private javax.swing.JPanel timelinePanel;
    private javax.swing.JPanel userProfilePanel;
    // End of variables declaration//GEN-END:variables
}
