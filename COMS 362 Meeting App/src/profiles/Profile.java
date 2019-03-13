package profiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Profile {

	String my_name;
	BufferedImage profile_picture;
	private int age;
	private String sexualPref;
	
	public Profile(){
		
	}
	
	public void set_name(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your first name below");
		String response = input.next();
		System.out.println("And now please enter your last name below");
		String response2 = input.next();
		this.my_name = response + " " + response2;
		System.out.println("Great! Your name will appear as: " + this.my_name + "!\n");
	}
	
	public void set_profile_picture(){
		System.out.println("Is the picture saved in the file structure? (y/n)");
		Scanner input = new Scanner(System.in);
		String response = input.next();
		boolean upload_complete = false;
		while(!upload_complete){
			if(response.equals("y")){
				System.out.println("Good! Now please enter the name of your picture file. (include .jpg, .png, etc.)");
				response = input.next();
				try{
					///////
					
					BufferedImage picture = ImageIO.read(new File(response));
					this.profile_picture = picture;
					/*
					 * This section will need to be changed once the server is set up to something more like:
					 * try {
					 * 		URL url = new URL(getCodeBase(), "pictures/sobble_is_best.png");
					 * 		img = ImageIO.read(url);
					 * }catch(IOException e){
					 * 		System.out.println("The picture you specified seems to be unavailable, please try again");
					 * }
					 */
					///////
					System.out.println("Your profile picture was added successfuly! The following picture will be displayed.");
					JFrame frame = new JFrame();
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.getContentPane().setLayout(new GridLayout(1, 1));
			        ImagePanel panel = new ImagePanel(this.profile_picture);
			        frame.getContentPane().add(panel);
			        frame.pack();
			        frame.setVisible(true);
				}catch(IOException e){
					System.out.println("The file name you specified was invalid, please try again");
				}
			}
			else
			{
				break;
			}
		}
	}
	
	public void remove_name(){
		this.my_name = null;
	}
	
	public void setAge(int input)
	{
		age = input;
	}
		
	public int getAge()
	{
		return age;
	}
	
	public void readAndSetAge()
	{
		System.out.println("Please enter your age below: ");
		Scanner input = new Scanner(System.in);
		int response;
		response = input.nextInt();
		setAge(response);
		System.out.println("You entered your age as: " + getAge() +"\n");
	}
	
	public void setSexPref(String input)
	{
		sexualPref = input;
	}
		
	public String getSexPref()
	{
		return sexualPref;
	}
	
	public void readAndSetSexualPref()
	{
		System.out.println("Would you like to set a Sexual Prefrence? (y/n)");
		Scanner input = new Scanner(System.in);
		String response;
		response = input.next();
		if(response.equals("y"))
		{
			System.out.println("Please enter your Sexual Prefrence ");
			response = input.next();
			setSexPref(response);
			System.out.println("You entered " + getSexPref() + "");
		}
		else
		{
			return;
		}
	}

	
	
	public void remove_profile_picture(){
		this.profile_picture = null;
	}
	
	public static void main(String args[]){
		//Test
		Profile p = new Profile();
		p.set_name();
		System.out.println(p.my_name);
		p.set_profile_picture();
		p.readAndSetAge();
		p.readAndSetSexualPref();
	}
	
	static class ImagePanel extends JPanel
    {
        private final BufferedImage image;

        ImagePanel(BufferedImage image)
        {
            this.image = image;
        }

        @Override
        public Dimension getPreferredSize()
        {
            if (super.isPreferredSizeSet())
            {
                return super.getPreferredSize();
            }
            return new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }
	
	
	
	
	
	
	
}
