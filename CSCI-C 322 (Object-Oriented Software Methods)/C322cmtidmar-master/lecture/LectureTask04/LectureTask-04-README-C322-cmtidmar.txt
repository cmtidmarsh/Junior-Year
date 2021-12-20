C322 Will Boland woboland 2/1/2021
Will Boland woboland@iu.edu
Christian Dummer cjdummer@iu.edu
Clare Tidmarsh cmtidmar@iu.edu

---Will Boland---
1: Is it more common to have one over-arching controller to handle the multiple MVC's, or to just pass data between the two controller's as needed?
2: If we went with a "one over-arching controller" design, what drawbacks would we expect to see?
3: If we went with passing data between controller's inside of different MVC's, what drawbacks would we expect to see?

---Christian Dummer---
1: Why not just create several different views with the one controller affecting each view?   
2: Alternatively, can't one view be made that is updated by the controller to display current information received from the model?
3: Is there any reason to have multiple controllers interacting with a view?

---Clare Tidmarsh---
1: How would we design the layout of the multitab simple so the user understands how to navigate?
2: Would the two tabs both be observers and would they have to both update if one changes?
3: What are the strengths and weaknesses of implementing one model, one controller, and 2 views vs implementing 2 MVCs? Which one would be more efficient?

---Categories---
Over-Arching: 1WB, 2WB, 1CD
Performance: 3WB, 3CD, 3CT, 2CT
Simplicity: 1CT, 2CD
