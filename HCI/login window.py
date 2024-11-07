import tkinter as tk
from tkinter import messagebox
root=tk.Tk()


root.title('Login')

root.configure(bg='Dark Slate Gray')

root.geometry ('300x400+60+60' )

def login_success():
    username = b1.get()  
    password = b2.get()  
    
    if username and password: 
        messagebox.showinfo("Login", "Login Successful!")
    else:
        messagebox.showwarning("Login", "Please enter both username and password!")

l1=tk.Label(root,text='Welcome User', fg='white', bg='Dark Slate Gray', font=('Times New Roman',14))

l1.pack()

l2=tk.Label(root, text='Username',fg='white', bg='Dark Slate Gray', font=('Times New Roman', 14))

l2.place( x = 30, y = 100 )

b1=tk.Entry(root, show='')

b1.place( x = 120, y = 100 )

l3=tk.Label(root, text='Password', fg='white', bg='Dark Slate Gray', font=('Times New Roman', 14))

l3.place ( x = 30, y = 150 )

b2=tk.Entry(root, show='*')

b2.place( x = 120 , y = 150 )

b3 = tk.Button(root, text='Login', command=login_success)

b3.place( x = 120, y = 200 )

root.mainloop()