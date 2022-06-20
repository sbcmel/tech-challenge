function Table({tableData}){
    console.log(tableData);
    return(
        <table className="table">
            <thead>
                <tr>
                    <th>S.N</th>
                    <th>Waypoint </th>
                    <th>Frequency</th>
                </tr>
            </thead>
            <tbody>
            {
                tableData.map((data, index)=>{
                    return(
                        <tr key={index}>
                            <td>{index+1}</td>
                            <td>{data.name}</td>
                            <td>{data.wpFrequency}</td>
                        </tr>
                    )
                })
            }
            </tbody>
        </table>
    )
}
export default Table;