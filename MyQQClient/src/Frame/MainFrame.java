package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.User;
import UserSocket.ChatTread;
import UserSocket.Client;
import _Util.CommandTranser;


/**
* @author zzz
* @version ����ʱ�䣺2018��7��2�� ����8:01:14
*/
//java��GUI����Ļ���˼·����JFrameΪ������������Ļ��window�Ķ����ܹ���󻯡���С�����رա�
public class MainFrame extends JFrame implements ActionListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private static final String _txt_account = "΢�ź�";
	private static final String _txt_pwd = "����";
	private static final String _txt_title = "΢��";
	private static final String _txt_registe = "ע��";
	private static final String _txt_forget = "��������";
	private static final String _txt_blank = "";
	

	//JLabel ��ǩ��Ҫ����չʾ �ı� �� ͼƬ��Ҳ���� ͬʱ��ʾ�ı���ͼƬ
	//JButton ����¼�
	//JTextArea �༭���е��ı���
	//JPasswordArea һ��ֻ���������ֵ������ ������������������ַ�����
	//JTabledPlan ѡ���塣�������û�ͨ��������������ͼ���ѡ�����һ�����֮������л���ʾ
	//JCheckBox ��ѡ���Ƿ�ѡ��
	//JPlanel JPanel�൱�ڽ��������廮�ֳɼ�����壬Ȼ���������ʹ�ò��ֹ�������������ť�Ĳ��֣�һ������ֻ����һ��JFrame�����ж��JPlanel
	//Imagin.SCALE_DEFAULT ����ӦJLabel�Ĵ�С
	//getScaledInstance ������ͼ������Ű汾������һ���µ� image ����Ĭ������£��ö���ָ���� width �� height ����ͼ��
	//��ʹ�Ѿ���ȫ�����˳�ʼԴͼ���µ� image ����Ҳ���Ա��첽����
	//SetIconͼ�꽫�ᱻ�Զ��طŵ���ť������,ȱʡʱ���з���
	//setborderpainted ���������Ӧ�û��Ʊ߿���Ϊ true������Ϊ false


	//private JLable txt_account, txt_pwd;
	private JTextField account;//�˺�
	private JPasswordField pwd;//����

	//��������
	private JLabel upper_frame;
	private JPanel lower_frame, center_frame;

	private JButton login, register, forget;

	MainFrame() {
		//���ֵ��γ�
		init();
		//�����γ�
		/*
		 * ���ԸĽ��ο� https://blog.csdn.net/qq_33531400/article/details/52839439
		 */
		add(upper_frame, BorderLayout.NORTH);
		add(center_frame, BorderLayout.CENTER);
		add(lower_frame, BorderLayout.SOUTH);
		ImageIcon logo = new ImageIcon("image/logo.png"); //���Ϸ�Сͼ��
		setIconImage(logo.getImage());
		setBounds(500, 230, 430, 360); //�趨��С��λ�ã�ǰ�����ǳ��ֵ�λ�ã���������ˮƽ������ֱ��
		setResizable(false); //��¼���С�̶���������ͨ���ϡ����ı��С
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //���ô������ϽǵĲ�ţ������Ŵ��ڹر� ע�ⲻ��EXIT_ON_CLOSE�������ģ�����ʱ��ʹ�õ���System.exit�����˳�Ӧ�ó��򡣹ʻ�ر����д��ڡ�
		setTitle(_txt_title);
		setVisible(true); //˵������ģ���Ѿ��������,����JVM���Ը�������ģ��ִ��paint������ʼ��ͼ����ʾ����Ļ�ϣ�һ��������һ��
	}
	public void init() {//��¼������������ڷ�
		//�˺������
		account = new JTextField(_txt_account);
		account.setName("account");
		account.setForeground(Color.gray);
		//account.setLocation(110, 165); //ȷ����С��λ��
		//account.setSize(210, 30);
		//setContentPane(account);
		account.addFocusListener(this); //�����¼���Ӧ�û���Ϊ

		//���������
		pwd = new JPasswordField(_txt_pwd);
		pwd.setName("pwd");
		pwd.setForeground(Color.gray);
		pwd.setEchoChar('\0'); //�������������һ��Ϊ �����롱
		//pwd.setLocation(110, 200);
		//pwd.setSize(210, 30);
		pwd.addFocusListener(this);

		//ע��ģ��
		register = new JButton(_txt_registe);
		register.setBorderPainted(false);
		register.setBorder(BorderFactory.createRaisedBevelBorder()); //б��߿�͹��
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		register.addActionListener(this);

		//��������ģ��
		forget = new JButton(_txt_forget);
		forget.setBorderPainted(false);
		forget.setBorder(BorderFactory.createRaisedBevelBorder());
		forget.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		forget.addActionListener(this);
				
		//login��ťģ��
		login = new JButton();
		ImageIcon login_image = new ImageIcon("image/login_image.png");
		login_image.setImage(login_image.getImage().getScaledInstance(430, 35, Image.SCALE_DEFAULT));
		login.setIcon(login_image);
		login.setBackground(Color.white);
		login.setBorderPainted(false); //���������Ӧ�û��Ʊ߿���Ϊ true������Ϊ false
		login.setBorder(null); //���ô�����ı߿� ��
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //�������Ϊ ��С�֡���״
		login.addActionListener(this);
						
		//qq��¼����ϰ벿�֣��ް�ť֮������ݣ�ֻ��һ��ͼƬ��
		ImageIcon upper_image = new ImageIcon("image/upper_image.png");
		upper_image.setImage(upper_image.getImage().getScaledInstance(430, 160, Image.SCALE_DEFAULT));
		upper_frame = new JLabel(upper_image);
				
		//qq��¼�м䲿�� (�˺š����롢 ע�ᡢforget)
		center_frame = new JPanel();
		center_frame.setName("center_frame");
		center_frame.setLayout(null);
		center_frame.setLayout(new GridLayout(3, 3, 3, 15)); //�����õ�3��3�еĿռ�, �ÿո����
		center_frame.add(new JLabel(_txt_blank, JLabel.CENTER));
		center_frame.add(account);
		center_frame.add(new JLabel(_txt_blank, JLabel.CENTER));
		center_frame.add(new JLabel(_txt_blank, JLabel.CENTER));
		center_frame.add(pwd);
		center_frame.add(new JLabel(_txt_blank, JLabel.CENTER));
		center_frame.add(register);
		center_frame.add(new JLabel(_txt_blank, JLabel.CENTER));
		center_frame.add(forget);
		center_frame.setBackground(Color.white);
				
		//qq��¼��ܵ��°벿��login
		lower_frame = new JPanel();
		lower_frame.setName("lower_frame");
		lower_frame.setLayout(null);
		//lower_frame.setLayout(new GridLayout(1, 3, 3, 15));
		lower_frame.setLayout(new GridLayout(0, 1)); 
		lower_frame.add(login);
	}
	//��ť�ĵ���¼���actionPerformed
	@Override
	public void actionPerformed(ActionEvent e){
		/*
		 * 1���������˵�¼��ť �����ж��ʺŻ��������Ƿ�Ϊ�� Ȼ���װΪCommandTranser���� ��������������� ������ͨ�������ݿ�ıȶ�
		 * ����֤�ʺ����룬
		 * 2����������ע���˺ž͵���ע��ҳ��, ��Ϣ��д���������ӷ�����
		 * 3�����������������뵯���һ�����ҳ��
		 */
		//������¼(login)ҳ��
		if(e.getSource() == login){
			String user_name = account.getText().trim();
			String user_pwd = new String(pwd.getPassword()).trim();
			if("".equals(user_name) || user_name == null || _txt_account.equals(user_name)) {
				JOptionPane.showMessageDialog(null, "�������ʺţ���");
				return;
			}
			if("".equals(user_pwd) || user_pwd == null || _txt_pwd.equals(user_pwd)) {
				JOptionPane.showMessageDialog(null, "���������룡��");
				return;
			}
			User user = new User(user_name, user_pwd);
			CommandTranser cmd = new CommandTranser();
			//����cmd��ֵ
			cmd.setCmd("login");
			cmd.setData(user);
			cmd.setReceiver(user_name);
			cmd.setSender(user_name);
			
			//ʵ�����ͻ��� ���ӷ����� �������� �����Ƿ���ȷ?
			
			Client client = new Client(); //����Ψһ�Ŀͻ��ˣ����ڽ��ܷ�������������Ϣ�� socket�ӿڣ��� 
			client.sendData(cmd); //��������
			cmd = client.getData(); //���ܷ�������Ϣ
			
			if(cmd != null) {
				if(cmd.isFlag()) {
					this.dispose(); //�ر�MainFrameҳ��
					/*
					 * ���ԸĽ���¼���ڵ����� һ��ʱ����Զ��ر� ��https://blog.csdn.net/qq_24448899/article/details/75731529
					 */
					System.out.println("��½�ɹ�,��ȷ��");
					JOptionPane.showMessageDialog(null,  "��½�ɹ�,��ȷ��");
					user = (User)cmd.getData(); 
					FriendsUI friendsUI = new FriendsUI(user, client); //��user��ȫ����Ϣ����FriendsUI�У�����Ψһ������������Ľӿڴ���FriendUI�� ���ﴫclient��Ϊ�˷�����Ϣ
					ChatTread thread = new ChatTread(client, user, friendsUI); //���ﴫclientΪ������Ϣ�� �����ͻ�����һ�� ChatTread��һ��client 
					thread.start();
				}else {
					/*
					 * ����this��null��ʲô����?
					 */
					JOptionPane.showMessageDialog(this, cmd.getResult());
				}
			}		
		}

		//����ע��(register)ҳ��
		if(e.getSource() == register){
			RegisterUI registerUI = new RegisterUI(this);
			//
		}

		//�����һ�����(forget)ҳ��
		if(e.getSource() == forget){
			ForgetUI forgetUI = new ForgetUI(this);
				
		}
			
	}
	
	//���ĵ�����ƶ�֮�����focuslistener
	@Override
	public void focusGained(FocusEvent e) {
		//�����˺������
    	if(e.getSource() == account){
			if(_txt_account.equals(account.getText())){
				account.setText("");
				account.setForeground(Color.BLACK);
			}
		}
    	
		//�������������
		if(e.getSource() == pwd){
			if(_txt_pwd.equals(pwd.getText())){
				pwd.setText("");
				pwd.setEchoChar('*');
				pwd.setForeground(Color.BLACK);
			}
		}
		
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		//�����˺������
		if(e.getSource() == account){
			if("".equals(account.getText())){
				account.setForeground(Color.gray);
				account.setText(_txt_account);
			}
		}
    	
		//�������������
		if(e.getSource() == pwd){
			if("".equals(pwd.getText())){
				pwd.setForeground(Color.gray);
				pwd.setText(_txt_pwd);
				pwd.setEchoChar('\0');
			}
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainframe = new MainFrame();
	}

}