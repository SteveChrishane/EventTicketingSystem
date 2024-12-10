import React from "react";

interface LogDisplayProps {
  logs: string[];
}

const LogDisplay: React.FC<LogDisplayProps> = ({ logs }) => {
  return (
    <div>
      <h2>Event Logs</h2>
      <div
        style={{
          maxHeight: "200px",
          overflowY: "auto",
          border: "1px solid #ccc",
        }}
      >
        {logs.map((log, index) => (
          <p key={index}>{log}</p>
        ))}
      </div>
    </div>
  );
};

export default LogDisplay;
