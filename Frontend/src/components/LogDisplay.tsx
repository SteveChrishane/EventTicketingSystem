interface LogDisplayProps {
  logs: string[];
}

function LogDisplay({ logs }: LogDisplayProps) {
  return (
    <div className="log-display">
      <h2>System Logs</h2>
      <ul>
        {logs.map((log, index) => (
          <li key={index}>{log}</li>
        ))}
      </ul>
    </div>
  );
}

export default LogDisplay;
