# Knapsack

## Compiling Java files using Eclipse IDE

1. Download this repository as ZIP
2. Create new `Java Project` in `Eclipse`
3. Right click on your `Java Project` --> `Import`
4. Choose `General` --> `Archive File`
5. Put directory where you downloaded ZIP in `From archive file`
6. Put `ProjectName/src` in `Into folder`
7. Click `Finish`
8. <strong>You must now change the directory names for each one to your preferred name as Java does not recognise `-` as valid identifiers. You need to subsequently do a `package <nameOfDir>` at the top of each `.java` file</strong> 

## Linking the jUnit library

8. Right click on your `Java Project` --> `Build Path` --> `Add Libraries`
9. Choose `jUnit` --> `Next`
10. Choose `jUnit 4` as the version
11. Click `Finish`

## Running the program

1. Right click on your `Java Project` --> `Run As` --> `Java Application`

## Notes

- The problem is solved using `dynamic programming`, `brute-force` and `graph search` algorithms
- `Testing.java` produces a file `<algoInitials>_test_results.csv` which shows the `average running times` in `ms` of the program using different parameters
- See proof, results and algorithm <a href='https://github.com/rjperez94/Knapsack/blob/master/Report.pdf'>here</a>
