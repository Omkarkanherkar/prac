import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

root = tk.Tk()
root.title('LOGIN')
root.geometry('500x700-60-60')
# root.resizable(False, False)
root.configure(bg='grey')

def login_success():
   
        messagebox.showinfo("Login", "Registration Successful!")

       


l2 = tk.Label(root, text='Student Registration Form', font=('Bold', 14))
l2.grid(row=0, column=1, pady=20)

# Student Name
l3 = tk.Label(root, text='Student Name', fg='black',bg='grey', font=('italic', 10))
l3.grid(row=1, column=0, pady=15)
t1 = tk.Entry(root)
t1.grid(row=1, column=1)

# Father Name
l4 = tk.Label(root, text='Father Name', fg='black',bg='grey', font=('italic', 10))
l4.grid(row=2, column=0, pady=15)
t2 = tk.Entry(root)
t2.grid(row=2, column=1)

# Gender
l5 = tk.Label(root, text='Gender', fg='black',bg='grey', font=('italic', 10))
l5.grid(row=3, column=0, pady=15)
rd_var = tk.IntVar()
rd1 = tk.Radiobutton(root, text='Male', variable=rd_var, value=1)
rd2 = tk.Radiobutton(root, text='Female', variable=rd_var, value=2)
rd1.grid(row=3, column=1)
rd2.grid(row=3, column=2)

# Language Known
l6 = tk.Label(root, text='Language Known', fg='black',bg='grey', font=('italic', 10))
l6.grid(row=4, column=0, pady=15)
rd_var2 = tk.IntVar()
rd4 = tk.Radiobutton(root, text='English', variable=rd_var2, value=1)
rd5 = tk.Radiobutton(root, text='Hindi', variable=rd_var2, value=2)
rd4.grid(row=4, column=1)
rd5.grid(row=4, column=2)

# Mobile Number
l7 = tk.Label(root, text='Mobile Number', fg='black',bg='grey', font=('italic', 10))
l7.grid(row=5, column=0, pady=15)
t3 = tk.Entry(root)
t3.grid(row=5, column=1)                                                        

# Course Selection
l8 = tk.Label(root, text='Select Course', fg='black',bg='grey', font=('italic', 10))
l8.grid(row=6, column=0, pady=15)

course_options = ['Computer', 'Mechanical', 'Electrical', 'Civil', 'IT']
course_var = tk.StringVar()
course_dropdown = ttk.Combobox(root, textvariable=course_var, values=course_options)
course_dropdown.grid(row=6, column=1)

# Address
l9 = tk.Label(root, text='Address', fg='black',bg='grey', font=('italic', 10))
l9.grid(row=7, column=0, pady=15)
t4 = tk.Entry(root)
t4.grid(row=7, column=1)
#submit
l10=tk.Button(root,text='SUBMIT',fg='black',bg='white', font=('italic', 10),command=login_success)
l10.grid(row=9 , column=1, pady=15)
root.mainloop()
